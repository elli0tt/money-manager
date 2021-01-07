package com.elli0tt.room_database.type_convertes

import androidx.room.TypeConverter
import java.util.*

class CalendarConverter {

    @TypeConverter
    fun fromCalendar(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun toCalendar(timeInMillis: Long): Calendar {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        return calendar
    }
}