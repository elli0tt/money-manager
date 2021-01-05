package com.elli0tt.feature_transaction_history.presentation.transaction_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.base.view_model.BaseAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import timber.log.Timber
import javax.inject.Inject

internal class TransactionListViewModel @Inject constructor(
    private val transactionHistoryRepository: TransactionHistoryRepository
) :
    BaseViewModel<TransactionListViewModel.ViewState, TransactionListViewModel.Action>() {

    internal data class ViewState(
        val isLoading: Boolean,
        val transactionList: List<TransactionDomainModel>
    ) : BaseViewState

    internal sealed class Action : BaseAction {

    }

    private var _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    init {
        Timber.d("TransactionListViewModel init() $transactionHistoryRepository")
        _text.postValue("TransactionList ${transactionHistoryRepository.getMockData()}")
    }
}