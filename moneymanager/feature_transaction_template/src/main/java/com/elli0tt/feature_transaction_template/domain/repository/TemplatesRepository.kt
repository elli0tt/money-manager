package com.elli0tt.feature_transaction_template.domain.repository

import com.elli0tt.feature_transaction_template.domain.model.TemplateDomainModel
import com.elli0tt.room_database.entities.TemplateEntity
import kotlinx.coroutines.flow.Flow

interface TemplatesRepository {

    val templatesList: Flow<List<TemplateDomainModel>>

    suspend fun insertTemplate(template: TemplateEntity)
}