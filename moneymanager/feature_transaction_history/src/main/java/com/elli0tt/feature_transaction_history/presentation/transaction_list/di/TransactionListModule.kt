package com.elli0tt.feature_transaction_history.presentation.transaction_list.di

import androidx.lifecycle.ViewModel
import com.elli0tt.feature_transaction_history.presentation.transaction_list.TransactionListViewModel
import com.elli0tt.money_manager.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TransactionListModule {

    @Binds
    @IntoMap
    @ViewModelKey(TransactionListViewModel::class)
    internal abstract fun bindTransactionListViewModel(viewModel: TransactionListViewModel): ViewModel
}