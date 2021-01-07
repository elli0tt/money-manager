package com.elli0tt.feature_transaction_history.presentation.add_transaction

import androidx.lifecycle.viewModelScope
import com.elli0tt.feature_transaction_history.R
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import com.elli0tt.room_database.entities.TransactionEntity
import com.elli0tt.room_database.enums.TransactionRoomType
import kotlinx.coroutines.launch
import timber.log.Timber
import java.text.DateFormat
import java.util.*
import javax.inject.Inject

internal class AddTransactionBottomSheetViewModel @Inject constructor(
    private val transactionHistoryRepository: TransactionHistoryRepository
) : BaseViewModel<AddTransactionBottomSheetViewModel.ViewState, AddTransactionBottomSheetViewModel.ViewAction>(
    ViewState()
) {

    companion object {
        private fun dateToString(date: Calendar): String {
            return DateFormat.getDateInstance(DateFormat.LONG).format(date.time)
        }
    }

    internal data class ViewState(
        var isSavedSuccessfully: Boolean = false,
        var isShowProgress: Boolean = false,
        var isShowDatePickDialog: Boolean = false,
        var date: Calendar = Calendar.getInstance(),
        var dateString: String = dateToString(date)
    ) : BaseViewState

    internal sealed class ViewAction : BaseViewAction {
        data class StartSavingTransaction(
            val name: String,
            val price: Double,
            val transactionTypeId: Int,
            val addToTemplates: Boolean
        ) : ViewAction()

        object TransactionSaveSuccess : ViewAction()
        object TransactionSaveFailure : ViewAction()

        object StartPickingDate : ViewAction()
        data class NewDatePicked(val year: Int, val month: Int, val dayOfMonth: Int) : ViewAction()
    }

    override fun onReduceState(viewAction: ViewAction): ViewState = when (viewAction) {
        is ViewAction.StartSavingTransaction -> onStartSavingTransaction(
            viewAction.name,
            viewAction.price,
            viewAction.transactionTypeId,
            viewAction.addToTemplates
        )
        is ViewAction.TransactionSaveSuccess -> state.copy(
            isSavedSuccessfully = true,
            isShowProgress = false,
            isShowDatePickDialog = false
        )
        is ViewAction.TransactionSaveFailure -> state
        is ViewAction.StartPickingDate -> state.copy(
            isSavedSuccessfully = false,
            isShowProgress = false,
            isShowDatePickDialog = true
        )
        is ViewAction.NewDatePicked -> onPickDate(
            year = viewAction.year,
            month = viewAction.month,
            dayOfMonth = viewAction.dayOfMonth
        )
    }

    private fun onStartSavingTransaction(
        name: String,
        price: Double,
        transactionTypeId: Int,
        addToTemplates: Boolean
    ): ViewState {
        viewModelScope.launch {
            Timber.d("Showing insert start")
            transactionHistoryRepository.insertTransaction(
                TransactionEntity(
                    name = name,
                    price = price,
                    date = Calendar.getInstance(),
                    transactionType = getTransactionType(transactionTypeId)
                )
            )
            Timber.d("Showing delay start")
//            delay(5000)
            Timber.d("Showing delay end")
            sendAction(ViewAction.TransactionSaveSuccess)
        }
        Timber.d("Showing progress")
        return state.copy(
            isSavedSuccessfully = false,
            isShowProgress = true,
            isShowDatePickDialog = false
        )
    }

    private fun getTransactionType(transactionTypeId: Int): TransactionRoomType =
        when (transactionTypeId) {
            R.id.expense_radio_button -> TransactionRoomType.EXPENSE
            R.id.income_radio_button -> TransactionRoomType.INCOME
            else -> throw IllegalArgumentException("No such transaction type")
        }

    private fun onPickDate(year: Int, month: Int, dayOfMonth: Int): ViewState {
        val newDate = Calendar.getInstance()
        newDate.set(Calendar.YEAR, year)
        newDate.set(Calendar.MONTH, month)
        newDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        return state.copy(
            isShowDatePickDialog = false,
            date = newDate,
            dateString = dateToString(newDate)
        )
    }
}