package com.android.ui.touchevent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.ui.R


class TextActivity : AppCompatActivity() {

    val TAG: String = "gaolei"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
    }
}
