package com.android.customview.dispatch

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import com.android.customview.R
import kotlinx.android.synthetic.main.activity_dispatch.*


class TextActivity : AppCompatActivity() {

    val TAG: String = "gaolei"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
    }
}
