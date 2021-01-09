package com.elli0tt.room_database.dao

import androidx.room.*
import com.elli0tt.room_database.entities.TemplateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {
    @Insert
    suspend fun insertTemplate(templateEntity: TemplateEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTemplateList(templateList: List<TemplateEntity>)

    @Update
    suspend fun updateTemplate(templateEntity: TemplateEntity)

    @Query("SELECT * FROM ${TemplateEntity.TABLE_NAME}")
    fun getTemplateList(): Flow<List<TemplateEntity>>

    @Query("DELETE FROM ${TemplateEntity.TABLE_NAME}")
    suspend fun deleteAllTemplates()
}