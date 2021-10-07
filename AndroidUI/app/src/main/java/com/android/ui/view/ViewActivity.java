package com.android.ui.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.ui.R;
import com.android.ui.view.maskfilter.MaskFilterActivity;
import com.android.ui.view.textview.TextViewActivity;

public class ViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }

    public void openStyleActivity(View view) {
        startActivity(new Intent(this, StyleActivity.class));
    }

    public void openCanvasActivity(View view) {
        startActivity(new Intent(this, CanvasActivity.class));
    }

    public void openStrokeActivity(View view) {
        startActivity(new Intent(this, TextViewActivity.class));
    }

    public void openCustomActivity(View view) {
        startActivity(new Intent(this, CustomActivity.class));
    }
    public void openMaskFilterActivity(View view) {
        startActivity(new Intent(this, MaskFilterActivity.class));
    }
}
