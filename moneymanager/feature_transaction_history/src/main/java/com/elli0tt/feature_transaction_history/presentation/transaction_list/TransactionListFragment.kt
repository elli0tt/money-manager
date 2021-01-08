package com.elli0tt.feature_transaction_history.presentation.transaction_list

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.elli0tt.feature_transaction_history.R
import com.elli0tt.feature_transaction_history.databinding.FragmentTransactionListBinding
import com.elli0tt.feature_transaction_history.presentation.adapter.TransactionRecyclerAdapter
import com.elli0tt.feature_transaction_history.presentation.add_transaction.AddTransactionBottomSheetFragment
import com.elli0tt.feature_transaction_history.presentation.transaction_list.di.DaggerTransactionListComponent
import com.elli0tt.money_manager.base.extensions.injectViewModel
import com.elli0tt.money_manager.base.extensions.viewBinding
import com.elli0tt.money_manager.base.fragment.BaseFragment
import timber.log.Timber
import javax.inject.Inject

class TransactionListFragment : BaseFragment(R.layout.fragment_transaction_list) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: TransactionListViewModel

    private val binding by viewBinding(FragmentTransactionListBinding::bind)

    private val transactionRecyclerAdapter = TransactionRecyclerAdapter()

    private lateinit var addTransactionBottomSheetFragment: AddTransactionBottomSheetFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDagger()
        initViews()
        render(viewModel.initialState)
        subscribeToViewModel()
    }

    private fun initDagger() {
        DaggerTransactionListComponent.factory().create(appComponent).inject(this)
        viewModel = injectViewModel(viewModelFactory)
        Timber.d("TransactionListViewModel $viewModel")
    }

    private fun render(viewState: TransactionListViewModel.ViewState) {
        transactionRecyclerAdapter.submitList(viewState.transactionList)
        if (viewState.isOpenAddTransactionBottomSheet) {
            openAddTransactionBottomSheetFragment()
        }
    }

    private fun subscribeToViewModel() {
        viewModel.stateLiveData.observe(viewLifecycleOwner) {
            render(it)
        }
    }

    private fun initViews() {
        initRecyclerView()
        setListeners()
    }

    private fun initRecyclerView() {
        binding.transactionRecyclerView.apply {
            adapter = transactionRecyclerAdapter
            setHasFixedSize(true)
        }
    }

    private fun setListeners() {
        binding.apply {
            toolbar.setOnMenuItemClickListener(toolbarMenuItemClickListener)
            addTransactionFab.setOnClickListener(addTransactionFabOnClickListener)
        }
    }

    private val toolbarMenuItemClickListener = Toolbar.OnMenuItemClickListener {
        when (it.itemId) {
            R.id.add_mock_transactions_menu_item -> {
                viewModel.sendAction(TransactionListViewModel.ViewAction.AddMockTransactionList)
                true
            }
            R.id.delete_all_transactions_menu_item -> {
                viewModel.sendAction(TransactionListViewModel.ViewAction.DeleteAllTransactions)
                true
            }

            else -> false
        }
    }

    private val addTransactionFabOnClickListener = View.OnClickListener {
        viewModel.sendAction(TransactionListViewModel.ViewAction.OpenAddTransactionScreen)
    }

    private fun openAddTransactionBottomSheetFragment() {
        addTransactionBottomSheetFragment = AddTransactionBottomSheetFragment()
        addTransactionBottomSheetFragment.transactionListViewModel = viewModel
        addTransactionBottomSheetFragment.show(
            childFragmentManager,
            AddTransactionBottomSheetFragment.TAG
        )
    }
}