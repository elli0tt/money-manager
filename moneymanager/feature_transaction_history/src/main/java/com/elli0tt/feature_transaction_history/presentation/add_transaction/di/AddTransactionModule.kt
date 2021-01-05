package com.elli0tt.feature_transaction_history.presentation.add_transaction.di

import androidx.lifecycle.ViewModel
import com.elli0tt.feature_transaction_history.presentation.add_transaction.AddTransactionViewModel
import com.elli0tt.money_manager.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddTransactionModule {
    @Binds
    @IntoMap
    @ViewModelKey(AddTransactionViewModel::class)
    internal abstract fun bindAddTransactionViewModel(viewModel: AddTransactionViewModel): ViewModel
}