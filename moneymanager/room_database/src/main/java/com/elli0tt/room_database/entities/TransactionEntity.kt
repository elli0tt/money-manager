package com.elli0tt.room_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elli0tt.room_database.entities.TransactionEntity.Companion.TABLE_NAME
import com.elli0tt.room_database.enums.TransactionRoomType
import java.util.*

@Entity(tableName = TABLE_NAME)
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var price: Double = 0.0,
    var date: Calendar = Calendar.getInstance(),
    var category: String = "",
    var transactionType: TransactionRoomType
) {
    companion object {
        const val TABLE_NAME = "transaction_table"
    }
}