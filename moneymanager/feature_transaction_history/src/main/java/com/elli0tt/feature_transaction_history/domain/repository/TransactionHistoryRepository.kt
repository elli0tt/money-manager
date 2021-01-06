package com.elli0tt.feature_transaction_history.domain.repository

import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import kotlinx.coroutines.flow.Flow

interface TransactionHistoryRepository {

    val transactionHistoryList: Flow<List<TransactionDomainModel>>
}