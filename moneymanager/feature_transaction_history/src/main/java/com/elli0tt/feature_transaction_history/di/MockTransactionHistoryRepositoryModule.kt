package com.elli0tt.feature_transaction_history.di

import com.elli0tt.feature_transaction_history.data.repository.MockTransactionHistoryRepositoryImpl
import com.elli0tt.feature_transaction_history.domain.repository.MockTransactionHistoryRepository
import dagger.Binds
import dagger.Module

@Module
abstract class MockTransactionHistoryRepositoryModule {

    @Binds
    abstract fun bindMockTransactionHistoryRepository(
        mockTransactionHistoryRepository: MockTransactionHistoryRepositoryImpl
    ): MockTransactionHistoryRepository
}