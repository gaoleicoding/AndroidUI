package com.android.customview.skin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.customview.R;

import skin.support.SkinCompatManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 指定皮肤插件
        SkinCompatManager.getInstance().loadSkin("night.skin", null, SkinCompatManager.SKIN_LOADER_STRATEGY_ASSETS);
    }

//
//    @NonNull
//    @Override
//    public AppCompatDelegate getDelegate() {
//        return SkinAppCompatDelegateImpl.get(this, this);
//    }
}
