package com.elli0tt.feature_transaction_template.presentation.add_template

import androidx.lifecycle.viewModelScope
import com.elli0tt.feature_transaction_template.R
import com.elli0tt.feature_transaction_template.domain.repository.TemplatesRepository
import com.elli0tt.money_manager.base.view_model.BaseViewAction
import com.elli0tt.money_manager.base.view_model.BaseViewModel
import com.elli0tt.money_manager.base.view_model.BaseViewState
import com.elli0tt.room_database.entities.TemplateEntity
import com.elli0tt.room_database.enums.TemplateRoomType
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

internal class AddTemplateBottomSheetViewModel @Inject constructor(
    private val templatesRepository: TemplatesRepository
) : BaseViewModel<AddTemplateBottomSheetViewModel.ViewState, AddTemplateBottomSheetViewModel.ViewAction>(
    ViewState()
) {
    internal data class ViewState(
        var isSavedSuccessfully: Boolean = false,
        var isShowProgress: Boolean = false,
    ) : BaseViewState

    internal sealed class ViewAction : BaseViewAction {
        data class StartSavingTemplate(
            val name: String,
            val price: Double,
            val templateTypeId: Int
        ) : ViewAction()

        object TemplateSaveSuccess : ViewAction()
        object TemplateSaveFailure : ViewAction()
    }

    override fun onReduceState(viewAction: ViewAction): ViewState = when (viewAction) {
        is ViewAction.StartSavingTemplate -> onStartSavingTemplate(
            viewAction.name,
            viewAction.price,
            viewAction.templateTypeId
        )
        is ViewAction.TemplateSaveSuccess -> state.copy(
            isSavedSuccessfully = true,
            isShowProgress = false
        )
        is ViewAction.TemplateSaveFailure -> state
    }

    private fun onStartSavingTemplate(
        name: String,
        price: Double,
        templateTypeId: Int
    ): ViewState {
        viewModelScope.launch {
            Timber.d("Showing insert start")
            templatesRepository.insertTemplate(
                TemplateEntity(
                    name = name,
                    price = price,
                    templateType = getTemplateType(templateTypeId)
                )
            )
            Timber.d("Showing delay start")
//            delay(5000)
            Timber.d("Showing delay end")
            sendAction(ViewAction.TemplateSaveSuccess)
        }
        Timber.d("Showing progress")
        return state.copy(
            isSavedSuccessfully = false,
            isShowProgress = true
        )
    }

    private fun getTemplateType(transactionTypeId: Int): TemplateRoomType =
        when (transactionTypeId) {
            R.id.expense_radio_button -> TemplateRoomType.EXPENSE
            R.id.income_radio_button -> TemplateRoomType.INCOME
            else -> throw IllegalArgumentException("No such template type")
        }
}