package com.elli0tt.money_manager.base.fragment

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.elli0tt.money_manager.App

abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId) {

    protected val app get() = context?.applicationContext as App

    protected val appComponent get() = app.appComponent
}