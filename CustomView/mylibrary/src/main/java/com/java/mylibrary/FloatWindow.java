package com.java.mylibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class FloatWindow {
    private WindowManager.LayoutParams mParams = null;
    private WindowManager windowManager = null;
    private Context context;
    private View mMenuView;
    private TextView mTvOne, mTvTwo, mTvThree;
    private TextView mTvCancel;

    private FloatWindow() {
    }

    private static FloatWindow instance;

    public static FloatWindow getInstance() {
        if (instance == null) {
            instance = new FloatWindow();
        }

        return instance;
    }

    public void showWindow(Context context) {
        if (windowManager == null) {
            windowManager = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        }

        Point size = new Point();
        windowManager.getDefaultDisplay().getSize(size);

        mParams = new WindowManager.LayoutParams();
        mParams.packageName = context.getPackageName();
        mParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        mParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        mParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        // 设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
//        mParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//        mParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        mParams.type = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;

//      mParams.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
//                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN;
        mParams.gravity = Gravity.END | Gravity.TOP;


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.layout_dialog, null);
        mTvCancel = mMenuView.findViewById(R.id.tv_cancel_show);
        windowManager.addView(mMenuView, mParams);
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideWindow();
            }
        });

    }

    public void hideWindow() {
        windowManager.removeView(mMenuView);
    }

    public void enterPage(String page) {

    }
}