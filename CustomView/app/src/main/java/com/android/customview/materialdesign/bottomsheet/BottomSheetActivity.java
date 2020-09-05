package com.android.customview.materialdesign.bottomsheet;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.android.customview.R;

public class BottomSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_dialog);
        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSheetDialog();
            }
        });
    }

    private void showSheetDialog() {

        TestBottomSheetDialogFragment bottomSheetDialog = new TestBottomSheetDialogFragment();
        bottomSheetDialog.show(getSupportFragmentManager(), "dialog");

    }

}
