package com.elli0tt.feature_transaction_history.domain.repository

import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel

interface TransactionHistoryRepository {

    fun getTransactionHistoryList(): List<TransactionDomainModel>
}