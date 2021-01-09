package com.elli0tt.feature_transaction_template.di

import com.elli0tt.feature_transaction_template.data.repository.MockTemplatesRepositoryImpl
import com.elli0tt.feature_transaction_template.domain.repository.MockTemplatesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class MockTemplatesRepositoryModule {

    @Binds
    abstract fun bindMockTemplatesRepository(
        mockTemplatesRepository: MockTemplatesRepositoryImpl
    ): MockTemplatesRepository
}