package com.elli0tt.feature_transaction_history.di

import com.elli0tt.feature_transaction_history.data.repository.TransactionHistoryRepositoryImpl
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class TransactionHistoryRepositoryModule {

    @Binds
    abstract fun bindTransactionHistoryRepository(
        transactionHistoryRepository: TransactionHistoryRepositoryImpl
    ): TransactionHistoryRepository
}