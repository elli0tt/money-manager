package com.elli0tt.feature_transaction_template.presentation.add_template.di

import com.elli0tt.feature_transaction_template.di.TemplatesRepositoryModule
import com.elli0tt.feature_transaction_template.presentation.add_template.AddTemplateBottomSheetFragment
import com.elli0tt.money_manager.di.AppComponent
import com.elli0tt.money_manager.di.modules.ViewModelModule
import dagger.Component

@AddTemplateBottomSheetScope
@Component(
    dependencies = [AppComponent::class],
    modules = [
        ViewModelModule::class,
        TemplatesRepositoryModule::class,
        AddTemplateBottomSheetModule::class
    ]
)
interface AddTemplateBottomSheetComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): AddTemplateBottomSheetComponent
    }

    fun inject(fragment: AddTemplateBottomSheetFragment)
}