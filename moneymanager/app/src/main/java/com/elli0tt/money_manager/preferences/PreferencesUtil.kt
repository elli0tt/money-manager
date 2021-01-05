package com.elli0tt.money_manager.preferences

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * SharedPreferences helper class
 */
class PreferencesUtil @Inject constructor(private val sharedPreferences: SharedPreferences) {

    /**
     * Put your keys here
     */
    private companion object {
        const val KEY_MOCK = "KEY_MOCK"
    }

    private val editor = sharedPreferences.edit()

    /**
     * Convenience methods
     */
    private fun putString(key: String, value: String) = editor.putString(key, value).apply()

    private fun putStringSet(key: String, value: Set<String>) =
        editor.putStringSet(key, value).apply()

    private fun putInt(key: String, value: Int) = editor.putInt(key, value).apply()

    private fun putLong(key: String, value: Long) = editor.putLong(key, value).apply()

    private fun putBoolean(key: String, value: Boolean) = editor.putBoolean(key, value).apply()

    private fun putFloat(key: String, value: Float) = editor.putFloat(key, value).apply()

    private fun getString(key: String, defValue: String): String? =
        sharedPreferences.getString(key, defValue)

    private fun getStringSet(key: String, defValue: Set<String>): Set<String>? =
        sharedPreferences.getStringSet(key, defValue)

    private fun getInt(key: String, defValue: Int): Int = sharedPreferences.getInt(key, defValue)

    private fun getLong(key: String, defValue: Long): Long =
        sharedPreferences.getLong(key, defValue)

    private fun getBoolean(key: String, defValue: Boolean): Boolean =
        sharedPreferences.getBoolean(key, defValue)

    private fun getFloat(key: String, defValue: Float): Float =
        sharedPreferences.getFloat(key, defValue)


    /**
     * Put your data access methods / properties here
     */
    fun getMockData() = getString(KEY_MOCK, "Mock data")

    fun setMockData(value: String) = putString(KEY_MOCK, value)
}