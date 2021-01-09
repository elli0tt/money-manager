package com.elli0tt.room_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elli0tt.room_database.dao.TemplateDao
import com.elli0tt.room_database.dao.TransactionDao
import com.elli0tt.room_database.entities.TemplateEntity
import com.elli0tt.room_database.entities.TransactionEntity
import com.elli0tt.room_database.type_convertes.CalendarConverter
import com.elli0tt.room_database.type_convertes.TemplateRoomTypeConverter
import com.elli0tt.room_database.type_convertes.TransactionRoomTypeConverter

@Database(entities = [TransactionEntity::class, TemplateEntity::class], version = 1)
@TypeConverters(
    CalendarConverter::class,
    TransactionRoomTypeConverter::class,
    TemplateRoomTypeConverter::class
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract val transactionDao: TransactionDao

    abstract val templateDao: TemplateDao
}