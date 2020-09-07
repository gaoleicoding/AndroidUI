package com.android.customview.material.behavior3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.android.customview.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class SetCarLocationBottomSheetBehavior extends BottomSheetBehavior {

    private View locationView;

    public SetCarLocationBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onMeasureChild(@NonNull CoordinatorLayout parent, @NonNull View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        if (locationView == null) {
            locationView = parent.findViewById(R.id.ib_my_location);
        }

        child.measure(parentWidthMeasureSpec
                , View.MeasureSpec.makeMeasureSpec(
                        (int) (View.MeasureSpec.getSize(parentHeightMeasureSpec) * 0.58F - locationView.getMeasuredHeight() - ((CoordinatorLayout.LayoutParams) locationView.getLayoutParams()).bottomMargin)
                        , View.MeasureSpec.EXACTLY));
        return true;
    }
}
