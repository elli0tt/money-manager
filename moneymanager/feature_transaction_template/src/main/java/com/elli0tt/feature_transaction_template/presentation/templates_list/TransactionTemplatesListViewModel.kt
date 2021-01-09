package com.elli0tt.feature_transaction_template.presentation.templates_list

import androidx.lifecycle.viewModelScope
import com.elli0tt.feature_transaction_template.domain.model.TemplateDomainModel
import com.elli0tt.feature_transaction_template.domain.repository.MockTemplatesRepository
import com.elli0tt.feature_transaction_template.domain.repository.TemplatesRepository
import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class TransactionTemplatesListViewModel @Inject constructor(
    private val templatesRepository: TemplatesRepository,
    private val mockTemplatesRepository: MockTemplatesRepository
) :
    BaseViewModel<TransactionTemplatesListViewModel.ViewState, TransactionTemplatesListViewModel.ViewAction>(
        ViewState()
    ) {

    internal data class ViewState(
        val isLoading: Boolean = false,
        val templatesList: List<TemplateDomainModel> = emptyList(),
        val isOpenAddTemplateBottomSheet: Boolean = false
    ) : BaseViewState

    internal sealed class ViewAction : BaseViewAction {
        object TemplatesListLoading : ViewAction()
        data class TemplatesListLoadingSuccess(val templatesList: List<TemplateDomainModel>) :
            ViewAction()

        object TemplatesListLoadingFailure : ViewAction()

        object AddMockTemplatesList : ViewAction()
        object DeleteAllTemplates : ViewAction()

        object OpenAddTransactionScreen : ViewAction()
        object CloseAddTransactionScreen : ViewAction()
    }

    init {
        subscribeToTemplatesListUpdates()
    }

    private fun subscribeToTemplatesListUpdates() {
        viewModelScope.launch {
            templatesRepository.templatesList.collect {
                sendAction(ViewAction.TemplatesListLoadingSuccess(it))
            }
        }
    }

    override fun onReduceState(viewAction: ViewAction): ViewState = when (viewAction) {
        is ViewAction.TemplatesListLoading -> state.copy(isLoading = true)
        is ViewAction.TemplatesListLoadingSuccess -> state.copy(
            isLoading = false,
            templatesList = viewAction.templatesList
        )
        is ViewAction.TemplatesListLoadingFailure -> state.copy(
            isLoading = false,
            templatesList = emptyList()
        )

        is ViewAction.AddMockTemplatesList -> onAddMockTemplatesList()
        is ViewAction.DeleteAllTemplates -> onDeleteAllTemplates()

        is ViewAction.OpenAddTransactionScreen -> state.copy(isOpenAddTemplateBottomSheet = true)
        is ViewAction.CloseAddTransactionScreen -> state.copy(isOpenAddTemplateBottomSheet = false)
    }

    private fun onAddMockTemplatesList(): ViewState {
        viewModelScope.launch {
            mockTemplatesRepository.insertMockTemplatesList()
        }
        return state
    }

    private fun onDeleteAllTemplates(): ViewState {
        viewModelScope.launch {
            mockTemplatesRepository.deleteAllTemplates()
        }
        return state
    }
}