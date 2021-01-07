package com.elli0tt.money_manager.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.elli0tt.money_manager.R
import com.elli0tt.money_manager.base.extensions.getThemeAttrColor

class ButtonWithRemoveIcon @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    CardView(context, attrs, defStyleAttr) {

    private val removeButton: AppCompatImageButton
    private val textView: TextView
    private val mainIconImageView: AppCompatImageView
    private val rootCardView: CardView

    fun setText(text: String) {
        textView.text = text
    }

    fun setText(@StringRes resId: Int) {
        textView.setText(resId)
    }

    override fun setBackgroundColor(@ColorRes resId: Int) {
        rootCardView.setCardBackgroundColor(resId)
    }

    fun setOnRemoveClickListener(listener: OnClickListener) {
        removeButton.setOnClickListener { v: View ->
            listener.onClick(v)
            v.visibility = INVISIBLE
        }
    }


    fun setRemoveIconVisibility(visibility: Int) {
        removeButton.visibility = visibility
    }

    init {
        inflate(context, R.layout.view_button_with_remove_icon, this)
        removeButton = findViewById(R.id.remove_icon_remove_button)
        textView = findViewById(R.id.remove_icon_text_view)
        mainIconImageView = findViewById(R.id.remove_icon_main_icon_image_view)
        rootCardView = findViewById(R.id.root_card_view)

        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.ButtonWithRemoveIcon, defStyleAttr, 0
        )
        mainIconImageView.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                typedArray.getResourceId(R.styleable.ButtonWithRemoveIcon_icon, 0)
            )
        )
        if (typedArray.hasValue(R.styleable.ButtonWithRemoveIcon_text)) {
            textView.setText(typedArray.getResourceId(R.styleable.ButtonWithRemoveIcon_text, 0))
        }

        setBackgroundColor(
            ContextCompat.getColor(
                context,
                typedArray.getResourceId(
                    R.styleable.ButtonWithRemoveIcon_background,
                    getThemeAttrColor(R.attr.colorPrimary)
                )
            )
        )
        if (typedArray.getBoolean(R.styleable.ButtonWithRemoveIcon_showRemoveIcon, true)) {
            removeButton.visibility = VISIBLE
        } else {
            removeButton.visibility = INVISIBLE
        }
        typedArray.recycle()
    }
}