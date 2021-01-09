package com.elli0tt.feature_transaction_history.domain.repository

import com.elli0tt.room_database.entities.TemplateEntity

interface TemplateRepository {

    suspend fun addTemplate(templateEntity: TemplateEntity)
}