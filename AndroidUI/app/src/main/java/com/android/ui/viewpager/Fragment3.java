package com.android.ui.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.ui.R;


public class Fragment3 extends BaseFragment {

    @Override
    protected void isFragmentVisible(boolean bool) {

    }

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment3, container, false);
        }

        return mRootView;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }


    public static Fragment3 newInstance() {
        Bundle args = new Bundle();

        Fragment3 fragment = new Fragment3();
        fragment.setArguments(args);
        return fragment;
    }
}