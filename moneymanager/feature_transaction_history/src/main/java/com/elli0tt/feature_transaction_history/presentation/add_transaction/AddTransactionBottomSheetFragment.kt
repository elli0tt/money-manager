package com.elli0tt.feature_transaction_history.presentation.add_transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_transaction_history.R
import com.elli0tt.feature_transaction_history.databinding.FragmentAddTransactionBottomSheetBinding
import com.elli0tt.feature_transaction_history.presentation.add_transaction.di.DaggerAddTransactionBottomSheetComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseBottomSheetDialogFragment
import javax.inject.Inject

class AddTransactionBottomSheetFragment : BaseBottomSheetDialogFragment() {

    companion object {
        const val TAG = "AddTransactionBottomSheetFragmentTag"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AddTransactionBottomSheetViewModel

    private val binding by viewBinding(FragmentAddTransactionBottomSheetBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_transaction_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        subscribeToViewModel()
    }

    private fun initDagger() {
        DaggerAddTransactionBottomSheetComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun subscribeToViewModel() {

    }
}