package com.android.customview.skin;

import android.os.Bundle;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.android.customview.R;
import com.android.customview.skin.loader.ZipSDCardLoader;

import skin.support.SkinCompatManager;
import skin.support.utils.SkinPreference;

public class ZipActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip);

        mToolbar = findViewById(R.id.toolbar);
        findViewById(R.id.default_theme).setOnClickListener(this);
        findViewById(R.id.default_zip_theme).setOnClickListener(this);
        findViewById(R.id.zip_theme).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SkinPreference.getInstance().getSkinStrategy() == ZipSDCardLoader.SKIN_LOADER_STRATEGY_ZIP) {
            mToolbar.setTitle("图片来自Zip包");
        } else {
            mToolbar.setTitle("图片来自应用本身");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.default_theme:
                SkinCompatManager.getInstance().restoreDefaultTheme();
                mToolbar.setTitle("图片来自应用本身");
                break;
            case R.id.default_zip_theme:
                SkinCompatManager.getInstance().loadSkin("", ZipSDCardLoader.SKIN_LOADER_STRATEGY_ZIP);
                mToolbar.setTitle("图片来自Zip包");
                break;
            case R.id.zip_theme:
                SkinCompatManager.getInstance().loadSkin("night.skin", ZipSDCardLoader.SKIN_LOADER_STRATEGY_ZIP);
                mToolbar.setTitle("图片来自Zip包");
                break;
        }
    }
}
