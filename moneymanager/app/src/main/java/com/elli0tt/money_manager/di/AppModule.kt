package com.elli0tt.money_manager.di

import android.content.Context
import android.content.SharedPreferences
import com.elli0tt.money_manager.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(
            context.getString(
                R.string.app_shared_preferences
            ), Context.MODE_PRIVATE
        )
}