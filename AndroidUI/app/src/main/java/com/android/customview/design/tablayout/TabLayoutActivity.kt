package com.android.customview.design.tablayout

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.android.customview.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {

    lateinit var mBaikeTablayout: TabLayout
    lateinit var mBaikeViewpager: ViewPager2
    val mTabTitles = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout)
        initView()
        initData()
    }

    fun initView() {
        mBaikeTablayout = findViewById(R.id.baike_second_tablayout)
        mBaikeViewpager = findViewById(R.id.baike_second_viewpager)
        mBaikeTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                mBaikeViewpager.setCurrentItem(tab.getPosition());
                val view = tab.getCustomView()
                val tv = view?.findViewById<TextView>(R.id.tv_baike_tab)
                tv?.setTypeface(Typeface.DEFAULT_BOLD)
                tv?.setTextSize(16f)
                tv?.setTextColor(
                    ContextCompat.getColor(
                        this@TabLayoutActivity,
                        R.color.color_FF6D33
                    )
                )
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val view = tab.getCustomView()
                val tv = view?.findViewById<TextView>(R.id.tv_baike_tab)
                tv?.setTypeface(Typeface.DEFAULT)
                tv?.setTextSize(14f)
                tv?.setTextColor(
                    ContextCompat.getColor(
                        this@TabLayoutActivity,
                        R.color.color_8A8FA4
                    )
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    fun initData() {
        val size = 10
        val mFragments = ArrayList<TabFragment>()

        for (i in 0 until size) {
            val baikeCategoryFragment = TabFragment()
            baikeCategoryFragment.setContent("第" + (i + 1) + "个页面")
            mFragments.add(baikeCategoryFragment)
            mTabTitles.add("Tab" + (i + 1))
        }
        val adapter = TabPagerAdapter(this, mFragments)
        mBaikeViewpager.offscreenPageLimit = mFragments.size
        mBaikeViewpager.adapter = adapter
        TabLayoutMediator(mBaikeTablayout, mBaikeViewpager) { tab, position ->
        }.attach()
        for (i in 0 until size) {
            if (i == 0) {
                // 在这里设置默认选中Tab第一项效果
                mBaikeTablayout.removeTabAt(0)
                mBaikeTablayout.addTab(
                    mBaikeTablayout.newTab().setCustomView(getTabView(i)),
                    0,
                    true
                );
            } else {
                val tab: TabLayout.Tab? = mBaikeTablayout.getTabAt(i)
                tab?.customView = getTabView(i)
            }
        }

    }

    fun getTabView(currentPosition: Int): View {
        val view: View = LayoutInflater.from(this).inflate(R.layout.tab_layout, null);
        val textView: TextView = view.findViewById(R.id.tv_baike_tab);
        textView.setText(mTabTitles.get(currentPosition));
        return view;
    }


}