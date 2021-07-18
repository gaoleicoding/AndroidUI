package com.android.ui.text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class CustomTextView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    var content: String = "测试文字ijkqwer"
    var mPaint: Paint
    var fontMetrics: Paint.FontMetrics
    var rect: Rect

    init {
        mPaint = Paint()
        fontMetrics = mPaint.getFontMetrics()
        rect = Rect(50, 50, 1000, 200);
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        mPaint.setColor(Color.CYAN);
        mPaint.textSize = sp2px(context, 18f).toFloat()
        canvas.drawRect(rect, mPaint);
        mPaint.setColor(Color.BLACK);
        var bottomLineY: Float =
            rect.centerY() - (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.top;
        var left: Float = rect.left.toFloat()
        canvas.drawText(content, left, bottomLineY, mPaint);

    }

    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}
