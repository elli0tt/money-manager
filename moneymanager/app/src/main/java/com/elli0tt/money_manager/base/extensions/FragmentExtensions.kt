package com.elli0tt.money_manager.base.extensions

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.elli0tt.money_manager.base.fragment.FragmentViewBindingDelegate

inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T =
    ViewModelProvider(this, factory)[T::class.java]

fun <Binding : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> Binding) =
    FragmentViewBindingDelegate(this, viewBindingFactory)