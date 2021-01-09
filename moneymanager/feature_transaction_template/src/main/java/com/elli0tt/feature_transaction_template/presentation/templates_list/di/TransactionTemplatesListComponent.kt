package com.elli0tt.feature_transaction_template.presentation.templates_list.di

import com.elli0tt.feature_transaction_template.di.MockTemplatesRepositoryModule
import com.elli0tt.feature_transaction_template.di.TemplatesRepositoryModule
import com.elli0tt.feature_transaction_template.presentation.templates_list.TransactionTemplatesListFragment
import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.modules.ViewModelModule
import dagger.Component

@TransactionTemplatesListScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ViewModelModule::class,
        TransactionTemplatesListModule::class,
        TemplatesRepositoryModule::class,
        MockTemplatesRepositoryModule::class
    ]
)
interface TransactionTemplatesListComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): TransactionTemplatesListComponent
    }

    fun inject(fragment: TransactionTemplatesListFragment)
}