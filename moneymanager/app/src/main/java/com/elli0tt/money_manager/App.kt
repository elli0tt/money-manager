package com.elli0tt.money_manager

import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.DaggerAppComponent
import com.google.android.play.core.splitcompat.SplitCompatApplication
import timber.log.Timber

class App : SplitCompatApplication() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initTimber()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.factory()
            .create(applicationContext)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}