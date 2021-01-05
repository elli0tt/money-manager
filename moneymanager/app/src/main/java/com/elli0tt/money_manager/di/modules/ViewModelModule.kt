package com.elli0tt.money_manager.di.modules

import androidx.lifecycle.ViewModelProvider
import com.elli0tt.money_manager.base.view_model.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}