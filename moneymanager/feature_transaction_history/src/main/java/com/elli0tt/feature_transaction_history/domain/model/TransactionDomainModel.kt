package com.elli0tt.feature_transaction_history.domain.model

import com.elli0tt.feature_transaction_history.domain.enums.TransactionDomainType
import java.util.*

data class TransactionDomainModel(
    var id: Int,
    var name: String,
    var price: Double,
    var date: Calendar,
    var category: String,
    var transactionType: TransactionDomainType
)