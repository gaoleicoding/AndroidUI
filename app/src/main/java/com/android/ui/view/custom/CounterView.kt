package com.android.ui.view.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

// 一、自绘控件
class CounterView(context: Context?, attrs: AttributeSet?) : View(context, attrs),
    View.OnClickListener {
    private val mPaint: Paint
    private val mBounds: Rect
    private var mCount = 0
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.color = Color.BLUE
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), mPaint)
        mPaint.color = Color.YELLOW
        mPaint.textSize = 30f
        val text = mCount.toString()
        mPaint.getTextBounds(text, 0, text.length, mBounds)
        val textWidth = mBounds.width().toFloat()
        val textHeight = mBounds.height().toFloat()
        canvas.drawText(
            text, width / 2 - textWidth / 2, height / 2
                    + textHeight / 2, mPaint
        )
    }

    override fun onClick(v: View) {
        mCount++
        invalidate()
    }

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mBounds = Rect()
        setOnClickListener(this)
    }
}