package com.elli0tt.feature_transaction_history.presentation.transaction_list

import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import javax.inject.Inject

internal class TransactionListViewModel @Inject constructor(
    private val transactionHistoryRepository: TransactionHistoryRepository
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
        loadData()
    }

    private fun loadData() {
        sendAction(ViewAction.TransactionListLoadingSuccess(transactionHistoryRepository.getTransactionHistoryList()))
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
}