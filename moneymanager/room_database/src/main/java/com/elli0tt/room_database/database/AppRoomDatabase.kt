package com.elli0tt.room_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elli0tt.room_database.dao.TransactionDao
import com.elli0tt.room_database.entities.TransactionEntity
import com.elli0tt.room_database.type_convertes.CalendarConverter

@Database(entities = [TransactionEntity::class], version = 1)
@TypeConverters(CalendarConverter::class)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getTransactionDao(): TransactionDao
}