package com.elli0tt.feature_transaction_statistics.presentation.di

import com.elli0tt.feature_transaction_statistics.presentation.StatisticsFragment
import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.modules.ViewModelModule
import dagger.Component

@StatisticsScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ViewModelModule::class, StatisticsModule::class]
)
interface StatisticsComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): StatisticsComponent
    }

    fun inject(fragment: StatisticsFragment)
}