package com.elli0tt.room_database.type_convertes

import androidx.room.TypeConverter
import com.elli0tt.room_database.enums.TemplateRoomType

class TemplateRoomTypeConverter {

    @TypeConverter
    fun fromEnum(templateRoomType: TemplateRoomType): Int = templateRoomType.ordinal

    @TypeConverter
    fun toEnum(ordinal: Int): TemplateRoomType = TemplateRoomType.values()[ordinal]
}