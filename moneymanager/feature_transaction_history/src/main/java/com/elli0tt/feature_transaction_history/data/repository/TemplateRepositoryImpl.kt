package com.elli0tt.feature_transaction_history.data.repository

import com.elli0tt.feature_transaction_history.domain.repository.TemplateRepository
import com.elli0tt.room_database.dao.TemplateDao
import com.elli0tt.room_database.entities.TemplateEntity
import javax.inject.Inject

class TemplateRepositoryImpl @Inject constructor(private val templateDao: TemplateDao) :
    TemplateRepository {

    override suspend fun addTemplate(templateEntity: TemplateEntity) {
        templateDao.insertTemplate(templateEntity)
    }
}