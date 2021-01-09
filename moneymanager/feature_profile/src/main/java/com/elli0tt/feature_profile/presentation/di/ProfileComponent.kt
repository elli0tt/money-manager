package com.elli0tt.feature_profile.presentation.di

import com.elli0tt.feature_profile.presentation.ProfileFragment
import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.modules.ViewModelModule
import dagger.Component

@ProfileScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ViewModelModule::class, ProfileModule::class]
)
interface ProfileComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): ProfileComponent
    }

    fun inject(fragment: ProfileFragment)
}