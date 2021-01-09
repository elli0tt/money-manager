package com.elli0tt.feature_transaction_template.presentation.add_template

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_transaction_template.R
import com.elli0tt.feature_transaction_template.databinding.FragmentAddTemplateBottomSheetBinding
import com.elli0tt.feature_transaction_template.presentation.add_template.di.DaggerAddTemplateBottomSheetComponent
import com.elli0tt.feature_transaction_template.presentation.templates_list.TransactionTemplatesListViewModel
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseBottomSheetDialogFragment
import timber.log.Timber
import javax.inject.Inject

class AddTemplateBottomSheetFragment :
    BaseBottomSheetDialogFragment(R.layout.fragment_add_template_bottom_sheet) {

    companion object {
        const val TAG = "AddTemplateBottomSheetFragmentTag"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AddTemplateBottomSheetViewModel
    internal lateinit var transactionListViewModel: TransactionTemplatesListViewModel

    private val binding by viewBinding(FragmentAddTemplateBottomSheetBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        initViews()
        render(viewModel.initialState)
        subscribeToViewModel()
    }

    private fun initDagger() {
        DaggerAddTemplateBottomSheetComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun render(viewState: AddTemplateBottomSheetViewModel.ViewState) {
        showProgress(viewState.isShowProgress)
        if (viewState.isSavedSuccessfully) {
            transactionListViewModel.sendAction(TransactionTemplatesListViewModel.ViewAction.CloseAddTransactionScreen)
            dismiss()
        }
    }

    private fun subscribeToViewModel() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            render(it)
        }
    }

    private fun initViews() {
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            saveButton.setOnClickListener(saveButtonOnClickListener)
        }
    }

    private val saveButtonOnClickListener = View.OnClickListener {
        binding.apply {
            viewModel.sendAction(
                AddTemplateBottomSheetViewModel.ViewAction.StartSavingTemplate(
                    name = nameTextInputEditText.text.toString(),
                    price = priceTextInputEditText.text.toString().toDouble(),
                    templateTypeId = templateTypeRadioGroup.checkedRadioButtonId
                )
            )
        }
    }

    private fun showProgress(isShowProgress: Boolean) {
        if (isShowProgress) {
            Timber.d("Progress is shown")
            binding.contentLoadingProgressBar.show()
        } else {
            Timber.d("Progress is hidden")
            binding.contentLoadingProgressBar.hide()
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        Timber.d("AddTransactionBottomSheet onCancel()")
        transactionListViewModel.sendAction(TransactionTemplatesListViewModel.ViewAction.CloseAddTransactionScreen)
    }
}