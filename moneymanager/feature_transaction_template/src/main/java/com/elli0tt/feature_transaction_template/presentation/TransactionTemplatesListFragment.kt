package com.elli0tt.feature_transaction_template.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_transaction_template.R
import com.elli0tt.feature_transaction_template.databinding.FragmentTransactionTemplatesListBinding
import com.elli0tt.feature_transaction_template.presentation.di.DaggerTransactionTemplatesListComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseFragment
import javax.inject.Inject

class TransactionTemplatesListFragment :
    BaseFragment(R.layout.fragment_transaction_templates_list) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: TransactionTemplatesListViewModel

    private val binding by viewBinding(FragmentTransactionTemplatesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        initViews()
        render(viewModel.initialState)
        subscribeToViewModel()
    }

    private fun initDagger() {
        DaggerTransactionTemplatesListComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun render(viewState: TransactionTemplatesListViewModel.ViewState) {

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

    }
}