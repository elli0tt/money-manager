package com.elli0tt.feature_transaction_template.domain.mapper

import com.elli0tt.feature_transaction_template.domain.model.TemplateDomainModel
import com.elli0tt.money_manager.base.mapper.Mapper
import com.elli0tt.room_database.entities.TemplateEntity
import javax.inject.Inject

class TemplateEntityToDomainMapper @Inject constructor(
    private val templateTypeRoomToDomainMapper: TemplateTypeRoomToDomainMapper
) :
    Mapper<TemplateEntity, TemplateDomainModel> {

    override fun map(input: TemplateEntity): TemplateDomainModel {
        return TemplateDomainModel(
            id = input.id,
            name = input.name,
            price = input.price,
            category = input.category,
            templateType = templateTypeRoomToDomainMapper.map(input.templateType)
        )
    }
}