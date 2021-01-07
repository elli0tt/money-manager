package com.elli0tt.feature_transaction_history.domain.repository

import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.room_database.entities.TransactionEntity
import kotlinx.coroutines.flow.Flow

interface TransactionHistoryRepository {

    val transactionHistoryList: Flow<List<TransactionDomainModel>>

    suspend fun insertTransaction(transaction: TransactionEntity)
}