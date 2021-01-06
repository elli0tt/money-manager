package com.elli0tt.feature_transaction_history.presentation.add_transaction

import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import com.elli0tt.room_database.database.AppRoomDatabase
import javax.inject.Inject

internal class AddTransactionViewModel @Inject constructor(
    private val transactionHistoryRepository: TransactionHistoryRepository,
    private val appRoomDatabase: AppRoomDatabase
) : BaseViewModel<AddTransactionViewModel.ViewState, AddTransactionViewModel.ViewAction>(ViewState()) {

    internal data class ViewState(var isLoading: Boolean = false) : BaseViewState

    internal sealed class ViewAction : BaseViewAction {

    }

    override fun onReduceState(viewAction: ViewAction): ViewState {
        return ViewState(false)
    }
}