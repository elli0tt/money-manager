package com.elli0tt.feature_transaction_history.data.repository

import com.elli0tt.feature_transaction_history.domain.enums.TransactionDomainType
import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.feature_transaction_history.domain.repository.MockTransactionHistoryRepository
import com.elli0tt.room_database.dao.TransactionDao
import com.elli0tt.room_database.entities.TransactionEntity
import com.elli0tt.room_database.enums.TransactionRoomType
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MockTransactionHistoryRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao
) :
    MockTransactionHistoryRepository {

    override suspend fun insertMockTransactionsList() {
        transactionDao.insertTransactionsList(generateMockTransactionEntityList())
    }

    override suspend fun deleteAllTransactions() {
        transactionDao.deleteAllTransactions()
    }

    private fun generateMockTransactionDomainList(): List<TransactionDomainModel> {
        val size = 50
        val result = ArrayList<TransactionDomainModel>(size)
        for (i in 0 until size) {
            result.add(
                TransactionDomainModel(
                    id = 0,
                    name = "Проезд в маршрутке $i",
                    price = 30.0,
                    date = Calendar.getInstance(),
                    category = "Транспорт",
                    transactionType = if (i % 2 == 0) TransactionDomainType.EXPENSE else TransactionDomainType.INCOME
                )
            )
        }
        return result
    }

    private fun generateMockTransactionEntityList(): List<TransactionEntity> {
        val size = 50
        val result = ArrayList<TransactionEntity>(size)
        for (i in 0 until size) {
            result.add(
                TransactionEntity(
                    id = 0,
                    name = "Проезд в маршрутке $i",
                    price = 30.0 + i * 3,
                    date = Calendar.getInstance(),
                    category = "Транспорт",
                    transactionType = if (i % 2 == 0) TransactionRoomType.EXPENSE else TransactionRoomType.INCOME
                )
            )
        }
        return result
    }
}