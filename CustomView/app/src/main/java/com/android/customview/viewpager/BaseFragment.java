package com.android.customview.viewpager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


/*
 优点：
  1.支持数据的懒加载并且只加载一次
  2.提供 Fragment 可见与不可见时回调，支持你在这里进行一些 ui 操作，如显示/隐藏加载框
  3.支持 view 的复用，防止与 ViewPager 使用时出现重复创建 view 的问题
  */
public abstract class BaseFragment extends Fragment {

    public final String TAG = getClass().getSimpleName();
    protected View mRootView;
    protected boolean isFirstVisible = false; //是否第一次加载
    private boolean isCreated = false;//是否初始化完成
    public static int sCount = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate:");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initVariable();
        if (mRootView == null) {
            mRootView = createView(inflater, container, savedInstanceState);
        }
        Log.d(TAG, "onCreateView:");
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        isCreated = true;
        Log.d(TAG, "onViewCreated:");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart:");
        sCount++;
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop:");
        sCount--;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume:");
        if (getUserVisibleHint()) {
            setUserVisibleHint(true);
        }
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        ((ViewGroup) mRootView.getParent()).removeView(mRootView);
        Log.d(TAG, "onDestroyView:");
        initVariable();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy:");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint: " + isVisibleToUser);
        //setUserVisibleHint有可能在fragment的生命周期外调用
        if (mRootView == null) {
            return;
        }
        if (isFirstVisible && isCreated && isVisibleToUser) {
            lazyLoad();
        }
        if (isVisibleToUser) {
            isFragmentVisible(true);
            Log.d(TAG, "已经对用户可见，可以加载数据" + ">>>>>>>>>>>>>>>>>>>");
        } else {
            isFragmentVisible(false);
            Log.d(TAG, "已经对用户不可见，可以停止加载数据" + ">>>>>>>>>>>>>>>>>>>");
        }
    }

    private void initVariable() {
        isFirstVisible = true;
        isCreated = false;
        mRootView = null;
    }

    /**
     * 懒加载
     */
    private void lazyLoad() {
        initData();
        isFirstVisible = false;

    }

    protected abstract void isFragmentVisible(boolean bool);

    protected abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initView(View view);

    protected abstract void initData();

}