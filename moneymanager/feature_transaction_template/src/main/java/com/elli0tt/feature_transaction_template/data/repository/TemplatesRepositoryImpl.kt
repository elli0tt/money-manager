package com.elli0tt.feature_transaction_template.data.repository

import com.elli0tt.feature_transaction_template.domain.mapper.TemplateEntityToDomainMapper
import com.elli0tt.feature_transaction_template.domain.model.TemplateDomainModel
import com.elli0tt.feature_transaction_template.domain.repository.TemplatesRepository
import com.elli0tt.room_database.dao.TemplateDao
import com.elli0tt.room_database.entities.TemplateEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TemplatesRepositoryImpl @Inject constructor(
    private val transactionDao: TemplateDao,
    private val templateEntityToDomainMapper: TemplateEntityToDomainMapper
) :
    TemplatesRepository {

    override val templatesList: Flow<List<TemplateDomainModel>> =
        transactionDao.getTemplateList()
            .map { transactionsList ->
                transactionsList.map {
                    templateEntityToDomainMapper.map(it)
                }
            }

    override suspend fun insertTemplate(template: TemplateEntity) {
        transactionDao.insertTemplate(template)
    }
}