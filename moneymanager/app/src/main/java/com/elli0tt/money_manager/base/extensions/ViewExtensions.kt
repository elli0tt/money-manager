package com.elli0tt.money_manager.base.extensions

import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes

@ColorRes
fun View.getThemeAttrColor(@AttrRes colorAttr: Int): Int {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(colorAttr, typedValue, true)
    return typedValue.resourceId
}