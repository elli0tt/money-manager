package com.elli0tt.feature_transaction_history.domain.repository

interface TransactionHistoryRepository {

    fun getMockData(): String?

    fun setMockData(value: String)
}