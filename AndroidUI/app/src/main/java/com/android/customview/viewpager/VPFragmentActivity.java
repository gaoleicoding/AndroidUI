package com.android.customview.viewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.customview.R;

import java.util.ArrayList;
import java.util.List;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT;
import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class VPFragmentActivity extends AppCompatActivity {
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp_fragment);
        vp = findViewById(R.id.viewpager);
        initData();
    }

    private void initData() {
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(Fragment1.newInstance());
        fragments.add(Fragment2.newInstance());
        fragments.add(Fragment3.newInstance());
        fragments.add(Fragment4.newInstance());
//        vp.setOffscreenPageLimit(fragments.size());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),BEHAVIOR_SET_USER_VISIBLE_HINT) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

    }
}