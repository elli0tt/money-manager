package com.elli0tt.money_manager.di

import android.content.Context
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

//    fun mainComponent(): MainComponent.Factory
//    fun audioModeComponent(): AudioModeComponent.Factory
//    fun readingModeComponent(): ReadingModeComponent.Factory
//    fun booksPagerComponent(): BooksPagerComponent.Factory
//    fun booksListComponent(): BooksListComponent.Factory
}