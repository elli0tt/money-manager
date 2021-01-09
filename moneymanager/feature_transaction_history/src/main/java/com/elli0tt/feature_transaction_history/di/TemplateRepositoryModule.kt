package com.elli0tt.feature_transaction_history.di

import com.elli0tt.feature_transaction_history.data.repository.TemplateRepositoryImpl
import com.elli0tt.feature_transaction_history.domain.repository.TemplateRepository
import dagger.Binds
import dagger.Module

@Module
abstract class TemplateRepositoryModule {

    @Binds
    abstract fun bindTemplateRepository(templateRepository: TemplateRepositoryImpl): TemplateRepository
}