package com.elli0tt.feature_transaction_history.data.repository

import com.elli0tt.feature_transaction_history.domain.mapper.TransactionEntityToDomainMapper
import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.room_database.dao.TransactionDao
import com.elli0tt.room_database.entities.TransactionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TransactionHistoryRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao,
    private val transactionEntityToDomainMapper: TransactionEntityToDomainMapper
) :
    TransactionHistoryRepository {

    override val transactionHistoryList: Flow<List<TransactionDomainModel>> =
        transactionDao.getTransactionsList()
            .map { transactionsList ->
                transactionsList.map {
                    transactionEntityToDomainMapper.map(it)
                }
            }

    override suspend fun insertTransaction(transaction: TransactionEntity) {
        transactionDao.insertTransaction(transaction)
    }
}