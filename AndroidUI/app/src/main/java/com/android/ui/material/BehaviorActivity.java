package com.android.ui.material;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.ui.R;
import com.android.ui.material.behavior.HeaderBehaviorActivity;
import com.android.ui.material.behavior2.GaodeBottomSheetActivity;
import com.android.ui.material.behavior3.SetCarLocationActivity;
import com.android.ui.material.bottomsheet.BottomSheetDialogActivity;
import com.android.ui.material.bottomsheet2.BottomSheetDialogActivity2;

public class BehaviorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
    }

    public void openHeaderBehaviorActivity(View view) {
        startActivity(new Intent(this, HeaderBehaviorActivity.class));
    }

    public void openGaodeBottomSheetActivity(View view) {
        startActivity(new Intent(this, GaodeBottomSheetActivity.class));
    }

    public void openSetCarLocationActivity(View view) {
        startActivity(new Intent(this, SetCarLocationActivity.class));
    }

    public void openBottomSheetDialogActivity(View view) {
        startActivity(new Intent(this, BottomSheetDialogActivity.class));
    }

    public void openBottomSheetDialogActivity2(View view) {
        startActivity(new Intent(this, BottomSheetDialogActivity2.class));
    }
}
