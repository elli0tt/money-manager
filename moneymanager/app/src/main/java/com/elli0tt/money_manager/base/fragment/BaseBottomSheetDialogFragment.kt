package com.elli0tt.money_manager.base.fragment

import com.elli0tt.money_manager.App
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetDialogFragment : BottomSheetDialogFragment() {

    protected val app get() = context?.applicationContext as App

    protected val appComponent get() = app.appComponent
}