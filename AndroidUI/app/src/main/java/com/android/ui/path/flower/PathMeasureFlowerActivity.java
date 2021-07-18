package com.android.ui.path.flower;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.ui.R;


public class PathMeasureFlowerActivity extends AppCompatActivity {

    private FlowerView fllower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fllower);

        fllower = (FlowerView) findViewById(R.id.fllower);
    }

    public void show(View view) {
        fllower.startAnimation();
    }

}
