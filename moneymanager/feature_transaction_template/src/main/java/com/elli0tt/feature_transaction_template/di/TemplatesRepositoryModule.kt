package com.elli0tt.feature_transaction_template.di

import com.elli0tt.feature_transaction_template.data.repository.TemplatesRepositoryImpl
import com.elli0tt.feature_transaction_template.domain.repository.TemplatesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class TemplatesRepositoryModule {

    @Binds
    abstract fun bindTemplatesRepository(
        templatesRepository: TemplatesRepositoryImpl
    ): TemplatesRepository
}