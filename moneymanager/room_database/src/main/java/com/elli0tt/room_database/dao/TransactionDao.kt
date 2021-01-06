package com.elli0tt.room_database.dao

import androidx.room.*
import com.elli0tt.room_database.entities.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert
    suspend fun insertTransaction(transactionEntity: TransactionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransactionsList(transactionsList: List<TransactionEntity>)

    @Update
    suspend fun updateTransaction(transactionEntity: TransactionEntity)

    @Query("SELECT * FROM ${TransactionEntity.TABLE_NAME}")
    fun getTransactionsList(): Flow<List<TransactionEntity>>
}