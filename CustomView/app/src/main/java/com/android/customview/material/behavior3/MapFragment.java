package com.android.customview.material.behavior3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.customview.R;

public class MapFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //通过参数中的布局填充获取对应布局
        View view =inflater.inflate(R.layout.fragment3,container,false);
        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
    }
}