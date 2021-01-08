package com.elli0tt.feature_settings.presentation.di

import com.elli0tt.feature_settings.presentation.SettingsFragment
import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.modules.ViewModelModule
import dagger.Component

@SettingsScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ViewModelModule::class, SettingsModule::class]
)
interface SettingsComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): SettingsComponent
    }

    fun inject(fragment: SettingsFragment)
}