package com.elli0tt.feature_transaction_history.domain.mapper

import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.money_manager.base.mapper.Mapper
import com.elli0tt.room_database.entities.TransactionEntity
import javax.inject.Inject

class TransactionEntityToDomainMapper @Inject constructor(
    private val transactionTypeRoomToDomainMapper: TransactionTypeRoomToDomainMapper
) :
    Mapper<TransactionEntity, TransactionDomainModel> {

    override fun map(input: TransactionEntity): TransactionDomainModel {
        return TransactionDomainModel(
            id = input.id,
            name = input.name,
            price = input.price,
            date = input.date,
            category = input.category,
            transactionType = transactionTypeRoomToDomainMapper.map(input.transactionType)
        )
    }
}