package com.elli0tt.feature_transaction_history.domain.repository

interface MockTransactionHistoryRepository {

    suspend fun insertMockTransactionsList()
}