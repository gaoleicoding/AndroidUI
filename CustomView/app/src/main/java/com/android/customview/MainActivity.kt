package com.android.customview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.customview.dispatch.DispatchActivity
import com.android.customview.dispatch.TextActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun skipToDispatch(view: View) {
        startActivity(Intent(this, DispatchActivity::class.java))
    }

    fun skipToText(view: View) {
        startActivity(Intent(this, TextActivity::class.java))
    }
}
