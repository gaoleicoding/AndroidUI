package com.java.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;


public class CustomPopWindow extends PopupWindow {
    private TextView mTvOne;
    private TextView mTvTwo;
    private TextView mTvThree;
    private TextView mTvCancel;
    private View mMenuView;

    public CustomPopWindow(Activity context, String[] nameList, View.OnClickListener itemsOnClick) {
        super(context);
//        super(context,R.style.transparentFrameWindowStyle);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.layout_popupwindow, null);
        mTvOne = mMenuView.findViewById(R.id.tv_one);
        mTvTwo = mMenuView.findViewById(R.id.tv_two);
        mTvThree = mMenuView.findViewById(R.id.tv_three);
        mTvCancel = mMenuView.findViewById(R.id.tv_cancel_show);


        mTvOne.setText(nameList[0]);
        mTvTwo.setText(nameList[1]);
        mTvThree.setText(nameList[2]);
        mTvOne.setOnClickListener(itemsOnClick);
        mTvTwo.setOnClickListener(itemsOnClick);
        mTvThree.setOnClickListener(itemsOnClick);

        //点击取消
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        //设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(720);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
//        this.setAnimationStyle(R.style.AnimBottom);
//        设置SelectPicPopupWindow弹出窗体可点击
        // 设置这两个属性
        this.setOutsideTouchable(false);
//        this.setFocusable(false);
        //实例化一个ColorDrawable颜色为半透明
//        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //实例化一个ColorDrawable颜色为全透明！！！为了和window底色融合，设置#00ffffff
//         ColorDrawable dw = new ColorDrawable(context.getResources().getColor(R.color.transparent));
        ColorDrawable dw = new ColorDrawable(context.getResources().getColor(R.color.black_75));
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        //mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框

    }
}