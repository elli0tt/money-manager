package com.elli0tt.room_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elli0tt.room_database.entities.TemplateEntity.Companion.TABLE_NAME
import com.elli0tt.room_database.enums.TemplateRoomType

@Entity(tableName = TABLE_NAME)
data class TemplateEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var price: Double = 0.0,
    var category: String = "",
    var templateType: TemplateRoomType
) {
    companion object {
        const val TABLE_NAME = "template_table"
    }
}