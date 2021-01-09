package com.elli0tt.feature_transaction_template.presentation.templates_list.di

import androidx.lifecycle.ViewModel
import com.elli0tt.feature_transaction_template.presentation.templates_list.TransactionTemplatesListViewModel
import com.elli0tt.money_manager.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TransactionTemplatesListModule {

    @TransactionTemplatesListScope
    @Binds
    @IntoMap
    @ViewModelKey(TransactionTemplatesListViewModel::class)
    internal abstract fun bindTransactionTemplatesListViewModel(viewModel: TransactionTemplatesListViewModel): ViewModel
}