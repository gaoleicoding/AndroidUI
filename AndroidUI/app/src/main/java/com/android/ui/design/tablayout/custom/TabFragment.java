package com.android.ui.design.tablayout.custom;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.ui.R;

public class TabFragment extends Fragment {

    private View rootView;

    public static TabFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putString("text", text);
        TabFragment fragment = new TabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_test, container, false);
        Log.i("fredZhu", "onCreateView");
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = rootView.findViewById(R.id.text_view);
        String text = getArguments() != null ? getArguments().getString("text") : null;
        textView.setText(text);
        Log.i("fredZhu", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fredZhu", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fredZhu", "onResume");
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }
}