package com.elli0tt.feature_transaction_history.presentation.add_transaction.di

import com.elli0tt.feature_transaction_history.di.TemplateRepositoryModule
import com.elli0tt.feature_transaction_history.di.TransactionHistoryRepositoryModule
import com.elli0tt.feature_transaction_history.presentation.add_transaction.AddTransactionBottomSheetFragment
import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.modules.ViewModelModule
import dagger.Component

@AddTransactionBottomSheetScope
@Component(
    dependencies = [AppComponent::class],
    modules = [
        ViewModelModule::class,
        TransactionHistoryRepositoryModule::class,
        AddTransactionBottomSheetModule::class,
        TemplateRepositoryModule::class
    ]
)
interface AddTransactionBottomSheetComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): AddTransactionBottomSheetComponent
    }

    fun inject(fragment: AddTransactionBottomSheetFragment)
}