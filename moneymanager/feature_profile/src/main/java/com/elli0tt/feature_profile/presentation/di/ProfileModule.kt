package com.elli0tt.feature_profile.presentation.di

import androidx.lifecycle.ViewModel
import com.elli0tt.feature_profile.presentation.ProfileViewModel
import com.elli0tt.money_manager.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProfileModule {

    @ProfileScope
    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel
}