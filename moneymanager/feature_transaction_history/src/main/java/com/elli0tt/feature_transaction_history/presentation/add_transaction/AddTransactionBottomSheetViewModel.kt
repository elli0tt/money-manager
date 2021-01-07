package com.elli0tt.feature_transaction_history.presentation.add_transaction

import androidx.lifecycle.viewModelScope
import com.elli0tt.feature_transaction_history.R
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import com.elli0tt.room_database.entities.TransactionEntity
import com.elli0tt.room_database.enums.TransactionRoomType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

internal class AddTransactionBottomSheetViewModel @Inject constructor(
    private val transactionHistoryRepository: TransactionHistoryRepository
) : BaseViewModel<AddTransactionBottomSheetViewModel.ViewState, AddTransactionBottomSheetViewModel.ViewAction>(
    ViewState()
) {

    internal data class ViewState(var isSavedSuccessfully: Boolean = false) : BaseViewState

    internal sealed class ViewAction : BaseViewAction {
        object TransactionSaveSuccess : ViewAction()
    }

    override fun onReduceState(viewAction: ViewAction): ViewState = when (viewAction) {
        is ViewAction.TransactionSaveSuccess -> state.copy(isSavedSuccessfully = true)
    }

    fun onSave(name: String, price: Double, transactionTypeId: Int, addToTemplates: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            transactionHistoryRepository.insertTransaction(
                TransactionEntity(
                    name = name,
                    price = price,
                    date = Calendar.getInstance(),
                    transactionType = getTransactionType(transactionTypeId)
                )
            )
            sendAction(ViewAction.TransactionSaveSuccess)
        }
    }

    private fun getTransactionType(transactionTypeId: Int): TransactionRoomType =
        when (transactionTypeId) {
            R.id.expense_radio_button -> TransactionRoomType.EXPENSE
            R.id.income_radio_button -> TransactionRoomType.INCOME
            else -> throw IllegalArgumentException("No such transaction type")
        }
}