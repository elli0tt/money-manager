package com.elli0tt.feature_transaction_template.domain.model

import com.elli0tt.feature_transaction_template.domain.enums.TemplateDomainType
import java.util.*

data class TemplateDomainModel(
    var id: Int,
    var name: String,
    var price: Double,
    var category: String,
    var templateType: TemplateDomainType
)