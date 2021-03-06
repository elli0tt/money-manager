package com.elli0tt.feature_profile.presentation

import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import javax.inject.Inject

internal class ProfileViewModel @Inject constructor() :
    BaseViewModel<ProfileViewModel.ViewState, ProfileViewModel.ViewAction>(
        ViewState()
    ) {

    internal data class ViewState(val isLoading: Boolean = false) : BaseViewState

    internal sealed class ViewAction : BaseViewAction

    override fun onReduceState(viewAction: ViewAction): ViewState {
        return state
    }
}