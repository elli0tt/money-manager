package com.elli0tt.feature_transaction_history.presentation.transaction_list

import androidx.lifecycle.viewModelScope
import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.feature_transaction_history.domain.repository.MockTransactionHistoryRepository
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class TransactionListViewModel @Inject constructor(
    private val transactionHistoryRepository: TransactionHistoryRepository,
    private val mockTransactionHistoryRepository: MockTransactionHistoryRepository
) :
    BaseViewModel<TransactionListViewModel.ViewState, TransactionListViewModel.ViewAction>(ViewState()) {

    internal data class ViewState(
        val isLoading: Boolean = false,
        val transactionList: List<TransactionDomainModel> = emptyList(),
        val isOpenAddTransactionBottomSheet: Boolean = false
    ) : BaseViewState

    internal sealed class ViewAction : BaseViewAction {
        object TransactionListLoading : ViewAction()
        data class TransactionListLoadingSuccess(val transactionList: List<TransactionDomainModel>) :
            ViewAction()

        object TransactionListLoadingFailure : ViewAction()

        object OpenAddTransactionScreen : ViewAction()
        object CloseAddTransactionScreen : ViewAction()

        object AddMockTransactionList : ViewAction()
        object DeleteAllTransactions : ViewAction()
    }

    init {
        subscribeToTransactionsListUpdates()
    }

    private fun subscribeToTransactionsListUpdates() {
        viewModelScope.launch {
            transactionHistoryRepository.transactionHistoryList.collect {
                sendAction(ViewAction.TransactionListLoadingSuccess(it))
            }
        }
    }

    override fun onReduceState(viewAction: ViewAction): ViewState =
        when (viewAction) {
        is ViewAction.TransactionListLoading -> state.copy(isLoading = true)
        is ViewAction.TransactionListLoadingSuccess -> state.copy(
            isLoading = false,
            isOpenAddTransactionBottomSheet = false,
            transactionList = viewAction.transactionList
        )
        is ViewAction.TransactionListLoadingFailure -> state.copy(
            isLoading = false,
            isOpenAddTransactionBottomSheet = false,
            transactionList = emptyList()
        )
        is ViewAction.OpenAddTransactionScreen -> state.copy(isOpenAddTransactionBottomSheet = true)
        is ViewAction.CloseAddTransactionScreen -> state.copy(isOpenAddTransactionBottomSheet = false)
        is ViewAction.AddMockTransactionList -> onAddMockTransactionsList()
        is ViewAction.DeleteAllTransactions -> onDeleteAllTransactions()
    }

    private fun onAddMockTransactionsList(): ViewState {
        viewModelScope.launch {
            mockTransactionHistoryRepository.insertMockTransactionsList()
        }
        return state
    }

    private fun onDeleteAllTransactions(): ViewState {
        viewModelScope.launch {
            mockTransactionHistoryRepository.deleteAllTransactions()
        }
        return state
    }
}