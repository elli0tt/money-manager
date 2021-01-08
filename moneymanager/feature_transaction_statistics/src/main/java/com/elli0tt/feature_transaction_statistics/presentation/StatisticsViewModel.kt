package com.elli0tt.feature_transaction_statistics.presentation

import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import javax.inject.Inject

internal class StatisticsViewModel @Inject constructor() :
    BaseViewModel<StatisticsViewModel.ViewState, StatisticsViewModel.ViewAction>(ViewState()) {

    internal data class ViewState(val isLoading: Boolean = false) : BaseViewState

    internal sealed class ViewAction : BaseViewAction

    override fun onReduceState(viewAction: ViewAction): ViewState {
        return state
    }
}