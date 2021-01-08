package com.elli0tt.feature_transaction_template.presentation.di

import com.elli0tt.feature_transaction_template.presentation.TransactionTemplatesListFragment
import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.modules.ViewModelModule
import dagger.Component

@TransactionTemplatesListScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ViewModelModule::class, TransactionTemplatesListModule::class]
)
interface TransactionTemplatesListComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): TransactionTemplatesListComponent
    }

    fun inject(fragment: TransactionTemplatesListFragment)
}