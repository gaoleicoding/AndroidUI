package com.android.customview.touchevent

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import com.android.customview.R
import kotlinx.android.synthetic.main.activity_dispatch.*


class DispatchActivity : AppCompatActivity() {

    val TAG: String = "gaolei"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dispatch)

        my_layout.setOnTouchListener(object : OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN ->
                        Log.d(
                            TAG, "my_layout      onTouch=ACTION_DOWN"
                        )
                    MotionEvent.ACTION_MOVE ->
                        Log.d(
                            TAG, "my_layout      onTouch=ACTION_MOVE"
                        )
                    MotionEvent.ACTION_UP -> Log.d(TAG, "my_layout      onTouch=ACTION_UP")
                }
                return false
            }
        })

        button1.setOnTouchListener(object : OnTouchListener {
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN ->
                        Log.d(
                            TAG, "button1      onTouch=ACTION_DOWN"
                        )
                    MotionEvent.ACTION_MOVE ->
                        Log.d(
                            TAG, "button1      onTouch=ACTION_MOVE"
                        )
                    MotionEvent.ACTION_UP -> Log.d(TAG, "button1      onTouch=ACTION_UP")
                }
                return false
            }
        })

    }
}
