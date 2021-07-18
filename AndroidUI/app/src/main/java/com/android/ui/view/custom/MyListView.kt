package com.android.ui.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.*
import android.view.View.OnClickListener
import android.view.View.OnTouchListener
import android.widget.ListView
import android.widget.RelativeLayout
import com.android.ui.R

// 三、继承控件
class MyListView(context: Context?, attrs: AttributeSet?) : ListView(context, attrs),
    OnTouchListener, GestureDetector.OnGestureListener {
    private val gestureDetector: GestureDetector
    private var listener: OnDeleteListener? = null
    private var deleteButton: View? = null
    private var itemLayout: ViewGroup? = null
    private var selectedItem = 0
    private var isDeleteShown = false
    fun setOnDeleteListener(l: OnDeleteListener?) {
        listener = l
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return if (isDeleteShown) {
            itemLayout!!.removeView(deleteButton)
            deleteButton = null
            isDeleteShown = false
            false
        } else {
            gestureDetector.onTouchEvent(event)
        }
    }

    override fun onDown(e: MotionEvent): Boolean {
        if (!isDeleteShown) {
            selectedItem = pointToPosition(e.x.toInt(), e.y.toInt())
        }
        return false
    }

    override fun onFling(
        e1: MotionEvent, e2: MotionEvent, velocityX: Float,
        velocityY: Float
    ): Boolean {
        if (!isDeleteShown && Math.abs(velocityX) > Math.abs(velocityY)) {
            deleteButton = LayoutInflater.from(context).inflate(
                R.layout.delete_button, null
            )
            deleteButton?.setOnClickListener(OnClickListener {
                itemLayout!!.removeView(deleteButton)
                deleteButton = null
                isDeleteShown = false
                listener!!.onDelete(selectedItem)
            })
            itemLayout = getChildAt(
                selectedItem
                        - firstVisiblePosition
            ) as ViewGroup
            val params = RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT
            )
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            params.addRule(RelativeLayout.CENTER_VERTICAL)
            itemLayout!!.addView(deleteButton, params)
            isDeleteShown = true
        }
        return false
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        return false
    }

    override fun onShowPress(e: MotionEvent) {}
    override fun onScroll(
        e1: MotionEvent, e2: MotionEvent, distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent) {}
    interface OnDeleteListener {
        fun onDelete(index: Int)
    }

    init {
        gestureDetector = GestureDetector(getContext(), this)
        setOnTouchListener(this)
    }
}