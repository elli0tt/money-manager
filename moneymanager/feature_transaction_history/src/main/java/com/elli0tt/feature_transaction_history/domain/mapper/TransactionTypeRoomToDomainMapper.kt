package com.elli0tt.feature_transaction_history.domain.mapper

import com.elli0tt.feature_transaction_history.domain.enums.TransactionDomainType
import com.elli0tt.money_manager.base.mapper.Mapper
import com.elli0tt.room_database.enums.TransactionRoomType
import javax.inject.Inject

class TransactionTypeRoomToDomainMapper @Inject constructor() :
    Mapper<TransactionRoomType, TransactionDomainType> {

    override fun map(input: TransactionRoomType): TransactionDomainType = when (input) {
        TransactionRoomType.EXPENSE -> TransactionDomainType.EXPENSE
        TransactionRoomType.INCOME -> TransactionDomainType.INCOME
    }
}