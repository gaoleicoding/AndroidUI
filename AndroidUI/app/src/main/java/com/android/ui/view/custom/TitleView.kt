package com.android.ui.view.custom

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.android.ui.R

// 二、组合控件
class TitleView(context: Context?, attrs: AttributeSet?) : FrameLayout(
    context!!, attrs
) {
    private val titleText: TextView
    fun setTitleText(text: String?) {
        titleText.text = text
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.title, this)
        titleText = findViewById(R.id.title_text)
        val leftButton = findViewById<ImageView>(R.id.button_left)
        leftButton.setOnClickListener { v: View? -> (getContext() as Activity).finish() }
    }
}