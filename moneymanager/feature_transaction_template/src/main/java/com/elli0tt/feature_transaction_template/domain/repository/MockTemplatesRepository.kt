package com.elli0tt.feature_transaction_template.domain.repository

interface MockTemplatesRepository {

    suspend fun insertMockTemplatesList()

    suspend fun deleteAllTemplates()
}