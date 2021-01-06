package com.elli0tt.money_manager.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.elli0tt.money_manager.R
import com.elli0tt.room_database.dao.TransactionDao
import com.elli0tt.room_database.database.AppRoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @JvmStatic
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(
            context.getString(
                R.string.app_shared_preferences
            ), Context.MODE_PRIVATE
        )

    @Singleton
    @JvmStatic
    @Provides
    fun provideAppRoomDatabase(context: Context): AppRoomDatabase {
        return Room.databaseBuilder(
            context,
            AppRoomDatabase::class.java,
            context.getString(R.string.app_room_database)
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @JvmStatic
    @Provides
    fun provideTransactionDao(appRoomDatabase: AppRoomDatabase): TransactionDao =
        appRoomDatabase.getTransactionDao()
}