package com.elli0tt.money_manager.base.viewHolder

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<Binding : ViewBinding, Model>(binding: Binding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(model: Model)

    @ColorInt
    protected fun getColor(@ColorRes colorResId: Int): Int {
        return ContextCompat.getColor(itemView.context, colorResId)
    }
}