package com.github.kongpf8848.animation.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class MyImageView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    var index = 0

    fun setAa(fraction: Float) {
        alpha = fraction
        scaleX = fraction
        scaleY = fraction
    }
}