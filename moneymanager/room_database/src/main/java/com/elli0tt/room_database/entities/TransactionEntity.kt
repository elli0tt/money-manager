package com.elli0tt.room_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "transaction_table", )
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var price: Double = 0.0,
    var date: Calendar = Calendar.getInstance(),
    var category: String = ""
)