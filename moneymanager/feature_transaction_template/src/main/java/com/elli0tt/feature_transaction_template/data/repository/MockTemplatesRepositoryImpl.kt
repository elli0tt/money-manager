package com.elli0tt.feature_transaction_template.data.repository

import com.elli0tt.feature_transaction_template.domain.enums.TemplateDomainType
import com.elli0tt.feature_transaction_template.domain.model.TemplateDomainModel
import com.elli0tt.feature_transaction_template.domain.repository.MockTemplatesRepository
import com.elli0tt.room_database.dao.TemplateDao
import com.elli0tt.room_database.entities.TemplateEntity
import com.elli0tt.room_database.enums.TemplateRoomType
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class MockTemplatesRepositoryImpl @Inject constructor(
    private val templateDao: TemplateDao
) :
    MockTemplatesRepository {

    override suspend fun insertMockTemplatesList() {
        templateDao.insertTemplateList(generateMockTemplatesEntityList())
    }

    override suspend fun deleteAllTemplates() {
        templateDao.deleteAllTemplates()
    }

    private fun generateMockTemplatesDomainList(): List<TemplateDomainModel> {
        val size = 50
        val result = ArrayList<TemplateDomainModel>(size)
        for (i in 0 until size) {
            result.add(
                TemplateDomainModel(
                    id = 0,
                    name = "Проезд в маршрутке $i",
                    price = 30.0,
                    category = "Транспорт",
                    templateType = if (i % 2 == 0) TemplateDomainType.EXPENSE else TemplateDomainType.INCOME
                )
            )
        }
        return result
    }

    private fun generateMockTemplatesEntityList(): List<TemplateEntity> {
        val size = 50
        val result = ArrayList<TemplateEntity>(size)
        for (i in 0 until size) {
            result.add(
                TemplateEntity(
                    id = 0,
                    name = "Проезд в маршрутке $i",
                    price = 30.0 + i * 3,
                    category = "Транспорт",
                    templateType = if (i % 2 == 0) TemplateRoomType.EXPENSE else TemplateRoomType.INCOME
                )
            )
        }
        return result
    }
}