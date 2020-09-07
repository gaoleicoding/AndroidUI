package com.android.customview.material.behavior3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.android.customview.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class SetCarLocationActivity extends Activity {

    private final String TAG = "SetCarLocationActivity";
    private RecyclerView mRecyclerView;
    private BottomSheetBehavior mBehavior;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_car_location);
        mRecyclerView = findViewById(R.id.recycler_view);
        ConstraintLayout clBottomSheet = findViewById(R.id.cl_bottom_sheet);
        mBehavior = ((BottomSheetBehavior) ((CoordinatorLayout.LayoutParams) clBottomSheet.getLayoutParams()).getBehavior());
        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "mRecyclerView.getTop(): " + mRecyclerView.getTop());
                int defaultPeekHeight = mRecyclerView.getTop() + 100 * 3;
                mBehavior.setPeekHeight(defaultPeekHeight);
            }
        });
    }


}
