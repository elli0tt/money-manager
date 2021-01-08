package com.elli0tt.feature_settings.presentation.di

import androidx.lifecycle.ViewModel
import com.elli0tt.feature_settings.presentation.SettingsViewModel
import com.elli0tt.money_manager.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SettingsModule {

    @SettingsScope
    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    internal abstract fun bindSettingsViewModel(viewModel: SettingsViewModel): ViewModel
}