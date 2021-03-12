package com.android.customview.path;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.customview.R;
import com.android.customview.path.flower.PathMeasureFlowerActivity;
import com.android.customview.path.progress.PathMeasureProgressActivity;
import com.android.customview.path.waterwave.PathWaterWaveActivity;

public class PathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
    }

    public void toPathFlowerActivity(View view) {
        startActivity(new Intent(this, PathMeasureFlowerActivity.class));
    }

    public void toPathStatusActivity(View view) {
        startActivity(new Intent(this, PathMeasureProgressActivity.class));
    }

    public void toWaterWaveActivity(View view) {
        startActivity(new Intent(this, PathWaterWaveActivity.class));
    }

}
