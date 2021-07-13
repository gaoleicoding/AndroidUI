package com.android.customview.view.custom;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.customview.R;

// 二、组合控件
public class TitleView extends FrameLayout {

    private final TextView titleText;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        titleText = findViewById(R.id.title_text);
        ImageView leftButton = findViewById(R.id.button_left);
        leftButton.setOnClickListener(v -> ((Activity) getContext()).finish());
    }

    public void setTitleText(String text) {
        titleText.setText(text);
    }


}