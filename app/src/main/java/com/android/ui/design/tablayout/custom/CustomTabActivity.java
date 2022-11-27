package com.android.ui.design.tablayout.custom;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.android.ui.R;


public class CustomTabActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    TabLayoutMediator mediator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tabs);
        mTabLayout = findViewById(R.id.activity_test_tabs_tl);
        mViewPager = findViewById(R.id.activity_test_tabs_view_pager);
//        mTabLayout.setSelectedTabIndicatorGravity(TabLayout.INDICATOR_GRAVITY_STRETCH);
        final String[] tabs = new String[]{"第一", "第二", "第三", "第四", "第五", "第六", "第七", "第八"};
        for (String t:tabs){
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setIcon(R.drawable.icon_black_back);
            tab.setText(t);
            mTabLayout.addTab(tab);
        }
        //禁用预加载
        mViewPager.setOffscreenPageLimit(ViewPager2.OFFSCREEN_PAGE_LIMIT_DEFAULT);
        //Adapter
        mViewPager.setAdapter(new FragmentStateAdapter(getSupportFragmentManager(), getLifecycle()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                //FragmentStateAdapter内部自己会管理已实例化的fragment对象。
                // 所以不需要考虑复用的问题
                return TabFragment.newInstance(tabs[position]);
            }

            @Override
            public int getItemCount() {
                return tabs.length;
            }
        });
        //viewPager 页面切换监听
        mViewPager.registerOnPageChangeCallback(changeCallback);

        mediator = new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setIcon(R.drawable.icon_black_back);
                tab.setText(tabs[position]);
            }
        });
        //要执行这一句才是真正将两者绑定起来
        mediator.attach();
    }

    private ViewPager2.OnPageChangeCallback changeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            //可以来设置选中时tab的大小
            int tabCount = mTabLayout.getTabCount();
            for (int i = 0; i < tabCount; i++) {
//                TabLayout.Tab tab = mTabLayout.getTabAt(i);
//                TextView tabView = (TextView) tab.getCustomView();
//                if (tab.getPosition() == position) {
//                    tabView.setTextSize(80);
//                    tabView.setTypeface(Typeface.DEFAULT_BOLD);
//                } else {
//                    tabView.setTextSize(60);
//                    tabView.setTypeface(Typeface.DEFAULT);
//                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        mediator.detach();
        mViewPager.unregisterOnPageChangeCallback(changeCallback);
        super.onDestroy();
    }


}
