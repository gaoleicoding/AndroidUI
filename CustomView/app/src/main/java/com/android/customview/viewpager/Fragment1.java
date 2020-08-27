package com.android.customview.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.customview.R;


public class Fragment1 extends BaseFragment {
    @Override
    protected void isFragmentVisible(boolean bool) {

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment1, container, false);
        }

        return mRootView;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }


    public static Fragment1 newInstance() {
        Bundle args = new Bundle();

        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }
}