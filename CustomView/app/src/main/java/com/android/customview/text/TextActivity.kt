package com.android.customview.touchevent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.customview.R


class TextActivity : AppCompatActivity() {

    val TAG: String = "gaolei"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
    }
}
