package com.android.customview.skin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import skin.support.annotation.Skinable;

/**
 * Created by ximsfei on 17-3-1.
 */

@Skinable
public class BaseActivity extends AppCompatActivity {
    protected void initToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("Title");
//        toolbar.setSubtitle("Subtitle");
//        toolbar.setNavigationIcon(R.drawable.ic_launcher_background);

    }

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }
}
