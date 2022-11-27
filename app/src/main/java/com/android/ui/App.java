package com.android.ui;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

import com.android.ui.skin.loader.CustomSDCardLoader;
import com.android.ui.skin.loader.ZipSDCardLoader;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

public class App extends Application {

    public void onCreate() {
        super.onCreate();
        SkinCompatManager.withoutActivity(this)
                .addStrategy(new CustomSDCardLoader())
                .addStrategy(new ZipSDCardLoader())     // 基础控件换肤初始化
                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
                .addInflater(new SkinConstraintViewInflater())          // ConstraintLayout 控件换肤初始化[可选]
                .addInflater(new SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
                .setSkinStatusBarColorEnable(false)                     // 关闭状态栏换肤，默认打开[可选]
                .setSkinWindowBackgroundEnable(false)                   // 关闭windowBackground换肤，默认打开[可选]
                .loadSkin();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

}
