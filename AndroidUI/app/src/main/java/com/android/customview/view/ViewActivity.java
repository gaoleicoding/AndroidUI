package com.android.customview.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.customview.R;
import com.android.customview.view.textview.StrokeTextViewActivity;

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
        startActivity(new Intent(this, StrokeTextViewActivity.class));
    }

    public void openCustomActivity(View view) {
        startActivity(new Intent(this, CustomActivity.class));
    }
}
