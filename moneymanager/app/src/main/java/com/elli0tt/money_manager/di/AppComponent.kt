package com.elli0tt.money_manager.di

import android.content.Context
import android.content.SharedPreferences
import com.elli0tt.money_manager.di.modules.AppModule
import com.elli0tt.room_database.dao.TemplateDao
import com.elli0tt.room_database.dao.TransactionDao
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): AppComponent
    }

    fun getAppContext(): Context

    fun getSharedPreferences(): SharedPreferences

    fun getTransactionDao(): TransactionDao

    fun getTemplateDao(): TemplateDao
}