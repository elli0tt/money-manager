package com.elli0tt.feature_transaction_statistics.presentation.di

import androidx.lifecycle.ViewModel
import com.elli0tt.feature_transaction_statistics.presentation.StatisticsViewModel
import com.elli0tt.money_manager.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class StatisticsModule {

    @StatisticsScope
    @Binds
    @IntoMap
    @ViewModelKey(StatisticsViewModel::class)
    internal abstract fun bindViewModel(viewModel: StatisticsViewModel): ViewModel
}