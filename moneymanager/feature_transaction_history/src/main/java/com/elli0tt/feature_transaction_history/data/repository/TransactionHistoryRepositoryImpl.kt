package com.elli0tt.feature_transaction_history.data.repository

import com.elli0tt.feature_transaction_history.domain.model.TransactionDomainModel
import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.preferences.PreferencesUtil
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class TransactionHistoryRepositoryImpl @Inject constructor(private val preferencesUtil: PreferencesUtil) :
    TransactionHistoryRepository {

    override fun getTransactionHistoryList(): List<TransactionDomainModel> {
        val size = 50
        val result = ArrayList<TransactionDomainModel>(size)
        for (i in 0 until size) {
            result.add(
                TransactionDomainModel(
                    id = i + 1,
                    name = "Проезд в маршрутке",
                    price = 30.0,
                    date = Calendar.getInstance(),
                    category = "Транспорт"
                )
            )
        }
        return result
    }
}