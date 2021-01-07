package com.elli0tt.room_database.type_convertes

import androidx.room.TypeConverter
import com.elli0tt.room_database.enums.TransactionRoomType

class TransactionRoomTypeConverter {

    @TypeConverter
    fun fromEnum(transactionRoomType: TransactionRoomType): Int = transactionRoomType.ordinal

    @TypeConverter
    fun toEnum(ordinal: Int): TransactionRoomType = TransactionRoomType.values()[ordinal]
}