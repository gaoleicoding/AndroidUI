package com.java.mylibrary;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

public class InfoDialog extends Dialog {

    private InfoDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {

        private View mLayout;

        private TextView mTvOne, mTvTwo, mTvThree;
        private TextView mTvCancel;

        private View.OnClickListener mButtonClickListener;

        private InfoDialog mDialog;

        public Builder(Context context) {
            mDialog = new InfoDialog(context, R.style.dialog);
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //加载布局文件
            mLayout = inflater.inflate(R.layout.layout_dialog, null, false);
            //添加布局文件到 Dialog
            mDialog.addContentView(mLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            mTvOne = mLayout.findViewById(R.id.tv_one);
            mTvTwo = mLayout.findViewById(R.id.tv_two);
            mTvThree = mLayout.findViewById(R.id.tv_three);
            mTvCancel = mLayout.findViewById(R.id.tv_cancel_show);
        }


        public InfoDialog create() {
            mTvCancel.setOnClickListener(view -> {
                mDialog.dismiss();
            });
            mDialog.setContentView(mLayout);
            mDialog.setCancelable(false);
            Window dialogWindow = mDialog.getWindow();
            dialogWindow.setGravity(Gravity.RIGHT);
            mDialog.setCanceledOnTouchOutside(false);   //用户不可以点击外部来关闭 Dialog
            return mDialog;
        }
    }
}