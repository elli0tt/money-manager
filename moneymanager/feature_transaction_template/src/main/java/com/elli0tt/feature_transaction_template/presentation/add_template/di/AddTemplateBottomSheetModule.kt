package com.elli0tt.feature_transaction_template.presentation.add_template.di

import androidx.lifecycle.ViewModel
import com.elli0tt.feature_transaction_template.presentation.add_template.AddTemplateBottomSheetViewModel
import com.elli0tt.money_manager.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddTemplateBottomSheetModule {

    @AddTemplateBottomSheetScope
    @Binds
    @IntoMap
    @ViewModelKey(AddTemplateBottomSheetViewModel::class)
    internal abstract fun bindAddTemplateViewModel(viewModel: AddTemplateBottomSheetViewModel): ViewModel
}