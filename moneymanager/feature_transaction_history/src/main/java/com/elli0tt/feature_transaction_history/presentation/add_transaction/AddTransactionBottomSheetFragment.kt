package com.elli0tt.feature_transaction_history.presentation.add_transaction

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_transaction_history.R
import com.elli0tt.feature_transaction_history.databinding.FragmentAddTransactionBottomSheetBinding
import com.elli0tt.feature_transaction_history.presentation.add_transaction.di.DaggerAddTransactionBottomSheetComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseBottomSheetDialogFragment
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class AddTransactionBottomSheetFragment :
    BaseBottomSheetDialogFragment(R.layout.fragment_add_transaction_bottom_sheet) {

    companion object {
        const val TAG = "AddTransactionBottomSheetFragmentTag"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AddTransactionBottomSheetViewModel

    private val binding by viewBinding(FragmentAddTransactionBottomSheetBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        initViews()
        render(viewModel.initialState)
        subscribeToViewModel()
    }

    private fun initDagger() {
        DaggerAddTransactionBottomSheetComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun render(viewState: AddTransactionBottomSheetViewModel.ViewState) {
        showProgress(viewState.isShowProgress)
        binding.pickDateButtonWithRemoveIcon.setText(viewState.dateString)
        if (viewState.isShowDatePickDialog) {
            showPickDateDialog(
                viewState.date.get(Calendar.YEAR),
                viewState.date.get(Calendar.MONTH),
                viewState.date.get(Calendar.DAY_OF_MONTH)
            )
        }
        if (viewState.isSavedSuccessfully) {
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
            pickDateButtonWithRemoveIcon.setOnClickListener(
                pickDateButtonWithRemoveIconOnClickListener
            )
        }
    }

    private val saveButtonOnClickListener = View.OnClickListener {
        binding.apply {
            viewModel.sendAction(
                AddTransactionBottomSheetViewModel.ViewAction.StartSavingTransaction(
                    name = nameTextInputEditText.text.toString(),
                    price = priceTextInputEditText.text.toString().toDouble(),
                    transactionTypeId = transactionTypeRadioGroup.checkedRadioButtonId,
                    addToTemplates = addToTemplatesCheckBox.isChecked
                )
            )
        }
    }

    private val pickDateButtonWithRemoveIconOnClickListener = View.OnClickListener {
        viewModel.sendAction(AddTransactionBottomSheetViewModel.ViewAction.StartPickingDate)
    }

    private fun showPickDateDialog(year: Int, month: Int, dayOfMonth: Int) {
        DatePickerDialog(
            requireContext(),
            datePickerDialogOnDateSetListener,
            year,
            month,
            dayOfMonth
        ).show()
    }

    private val datePickerDialogOnDateSetListener =
        DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            viewModel.sendAction(
                AddTransactionBottomSheetViewModel.ViewAction.NewDatePicked(
                    year,
                    month,
                    dayOfMonth
                )
            )
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
}