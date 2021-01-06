package com.elli0tt.feature_transaction_history.presentation.transaction_list.di

import com.elli0tt.feature_transaction_history.di.TransactionHistoryRepositoryModule
import com.elli0tt.feature_transaction_history.presentation.transaction_list.TransactionListFragment
import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.modules.AppModule
import com.elli0tt.money_manager.di.modules.ViewModelModule
import dagger.Component

@TransactionListScope
@Component(
    dependencies = [AppComponent::class],
    modules = [
        ViewModelModule::class,
        TransactionListModule::class,
        TransactionHistoryRepositoryModule::class
    ]
)
interface TransactionListComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): TransactionListComponent
    }

    fun inject(fragment: TransactionListFragment)
}