package com.elli0tt.money_manager.base.fragment

import androidx.fragment.app.Fragment
import com.elli0tt.money_manager.App

abstract class BaseFragment : Fragment() {

    protected val app get() = context?.applicationContext as App

    protected val appComponent get() = app.appComponent
}