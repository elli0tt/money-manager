package com.elli0tt.feature_transaction_history.presentation.transaction_list

import androidx.lifecycle.viewModelScope
import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.feature_transaction_history.domain.repository.MockTransactionHistoryRepository
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import kotlinx.coroutines.Dispatchers
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
        val transactionList: List<TransactionDomainModel> = emptyList()
    ) : BaseViewState

    internal sealed class ViewAction : BaseViewAction {
        data class TransactionListLoadingSuccess(val transactionList: List<TransactionDomainModel>) :
            ViewAction()

        object TransactionListLoadingFailure : ViewAction()
    }

    init {
        subscribeToTransactionsListUpdates()
    }

    private fun subscribeToTransactionsListUpdates() {
        viewModelScope.launch(Dispatchers.IO) {
            transactionHistoryRepository.transactionHistoryList.collect {
                sendAction(ViewAction.TransactionListLoadingSuccess(it))
            }
        }
    }

    override fun onReduceState(viewAction: ViewAction): ViewState = when (viewAction) {
        is ViewAction.TransactionListLoadingSuccess -> state.copy(
            isLoading = false,
            transactionList = viewAction.transactionList
        )
        is ViewAction.TransactionListLoadingFailure -> state.copy(
            isLoading = false,
            transactionList = emptyList()
        )
    }

    fun onAddMockTransactionsList() {
        viewModelScope.launch(Dispatchers.IO) {
            mockTransactionHistoryRepository.insertMockTransactionsList()
        }
    }

    fun onDeleteAllTransactions() {
        viewModelScope.launch(Dispatchers.IO) {
            mockTransactionHistoryRepository.deleteAllTransactions()
        }
    }
}