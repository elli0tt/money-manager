package com.elli0tt.feature_transaction_history.presentation.transaction_list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_transaction_history.R
import com.elli0tt.feature_transaction_history.databinding.FragmentTransactionListBinding
import com.elli0tt.feature_transaction_history.presentation.adapter.TransactionRecyclerAdapter
import com.elli0tt.feature_transaction_history.presentation.transaction_list.di.DaggerTransactionListComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseFragment
import javax.inject.Inject

class TransactionListFragment : BaseFragment(R.layout.fragment_transaction_list) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: TransactionListViewModel

    private val binding by viewBinding(FragmentTransactionListBinding::bind)

    private val transactionRecyclerAdapter = TransactionRecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        subscribeToViewModel()
        initViews()
    }

    private fun initDagger() {
        DaggerTransactionListComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
    }

    private fun subscribeToViewModel() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            transactionRecyclerAdapter.submitList(it.transactionList)
        }
    }

    private fun initViews() {
        initRecyclerView()
        setListeners()
    }

    private fun initRecyclerView() {
        binding.transactionRecyclerView.apply {
            adapter = transactionRecyclerAdapter
        }
    }

    private fun setListeners() {
        binding.apply {
            toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.add_mock_transactions_menu_item -> {
                        viewModel.onAddMockTransactionsList()
                        true
                    }
                    R.id.delete_all_transactions_menu_item -> {
                        viewModel.onDeleteAllTransactions()
                        true
                    }

                    else -> false
                }
            }
        }
    }
}