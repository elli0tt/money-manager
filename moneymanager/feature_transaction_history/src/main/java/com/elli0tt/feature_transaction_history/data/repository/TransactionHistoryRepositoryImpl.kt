package com.elli0tt.feature_transaction_history.data.repository

import com.elli0tt.feature_transaction_history.domain.repository.TransactionHistoryRepository
import com.elli0tt.money_manager.preferences.PreferencesUtil
import javax.inject.Inject
import javax.inject.Singleton

class TransactionHistoryRepositoryImpl @Inject constructor(private val preferencesUtil: PreferencesUtil) :
    TransactionHistoryRepository {

    override fun getMockData() = preferencesUtil.getMockData()

    override fun setMockData(value: String) = preferencesUtil.setMockData(value)
}