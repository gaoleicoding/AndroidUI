package com.android.customview.view.textview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.customview.R;

public class StrokeTextViewActivity extends Activity {

    private TextView tvOuterStroke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke_textview);
        tvOuterStroke = findViewById(R.id.text_outer_stroke);
		tvOuterStroke.setShadowLayer(12,0,0, Color.WHITE);
    }

}
