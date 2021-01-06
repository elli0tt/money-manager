package com.elli0tt.feature_transaction_history.presentation.add_transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.base.view_model.BaseAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import com.elli0tt.room_database.database.AppRoomDatabase
import timber.log.Timber
import javax.inject.Inject

internal class AddTransactionViewModel @Inject constructor(
    private val transactionHistoryRepository: TransactionHistoryRepository,
    private val appRoomDatabase: AppRoomDatabase
) : BaseViewModel<AddTransactionViewModel.ViewState, AddTransactionViewModel.Action>() {

    internal data class ViewState(var isLoading: Boolean) : BaseViewState

    internal sealed class Action : BaseAction {

    }

    private var _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    init {
        Timber.d("AddTransactionHistory init() $appRoomDatabase")
        _text.postValue("AddTransaction ${transactionHistoryRepository.getMockData()}")
    }
}