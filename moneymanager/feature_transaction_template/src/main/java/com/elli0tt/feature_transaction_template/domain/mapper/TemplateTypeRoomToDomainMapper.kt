package com.elli0tt.feature_transaction_template.domain.mapper

import com.elli0tt.feature_transaction_template.domain.enums.TemplateDomainType
import com.elli0tt.money_manager.base.mapper.Mapper
import com.elli0tt.room_database.enums.TemplateRoomType
import javax.inject.Inject

class TemplateTypeRoomToDomainMapper @Inject constructor() :
    Mapper<TemplateRoomType, TemplateDomainType> {

    override fun map(input: TemplateRoomType): TemplateDomainType = when (input) {
        TemplateRoomType.EXPENSE -> TemplateDomainType.EXPENSE
        TemplateRoomType.INCOME -> TemplateDomainType.INCOME
    }
}