package com.elli0tt.feature_transaction_history.presentation.add_transaction

import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import javax.inject.Inject

internal class AddTransactionBottomSheetViewModel @Inject constructor(
    private val transactionHistoryRepository: TransactionHistoryRepository
) : BaseViewModel<AddTransactionBottomSheetViewModel.ViewState, AddTransactionBottomSheetViewModel.ViewAction>(ViewState()) {

    internal data class ViewState(var isLoading: Boolean = false) : BaseViewState

    internal sealed class ViewAction : BaseViewAction {

    }

    override fun onReduceState(viewAction: ViewAction): ViewState {
        return ViewState(false)
    }
}