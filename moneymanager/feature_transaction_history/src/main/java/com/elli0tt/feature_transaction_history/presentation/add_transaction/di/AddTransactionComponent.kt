package com.elli0tt.feature_transaction_history.presentation.add_transaction.di

import com.elli0tt.feature_transaction_history.di.TransactionHistoryRepositoryModule
import com.elli0tt.feature_transaction_history.presentation.add_transaction.AddTransactionFragment
import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.modules.AppModule
import com.elli0tt.money_manager.di.modules.ViewModelModule
import dagger.Component

@AddTransactionScope
@Component(
    dependencies = [AppComponent::class],
    modules = [
        ViewModelModule::class,
        TransactionHistoryRepositoryModule::class,
        AddTransactionModule::class
    ]
)
interface AddTransactionComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): AddTransactionComponent
    }

    fun inject(fragment: AddTransactionFragment)
}