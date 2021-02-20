package com.android.customview.viewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.customview.R;

public class ViewPagerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
    }

    public void openVPFragmentActivity(View view) {
        startActivity(new Intent(this, VPFragmentActivity.class));
    }

    public void openVPInfiniteActivity(View view) {
        startActivity(new Intent(this, VPInfiniteActivity.class));
    }
}
