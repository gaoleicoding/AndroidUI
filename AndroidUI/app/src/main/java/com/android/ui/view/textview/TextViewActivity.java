package com.android.ui.view.textview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.android.ui.R;

public class TextViewActivity extends Activity {

    private TextView tvOuterStroke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke_textview);
        tvOuterStroke = findViewById(R.id.text_outer_stroke);
		tvOuterStroke.setShadowLayer(12,0,0, Color.WHITE);
    }

}
