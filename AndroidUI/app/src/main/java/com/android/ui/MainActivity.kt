package com.android.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.ui.activity.PartActivity
import com.android.ui.adapter.DividerItemDecoration
import com.android.ui.adapter.ItemAdapter
import com.android.ui.motionlayout.MotionLayoutActivity
import com.android.ui.calculator.CalculatorActivity
import com.android.ui.design.CollapseActivity
import com.android.ui.design.tablayout.TabLayoutActivity
import com.android.ui.material.behavior3.SetCarLocationActivity
import com.android.ui.material.bottomsheet.BottomSheetActivity
import com.android.ui.nestedscroll.NestedScrollActivity
import com.android.ui.path.PathActivity
import com.android.ui.recorder.RecorderActivity
import com.android.ui.skin.ZipActivity
import com.android.ui.touchevent.TextActivity
import com.android.ui.touchevent.TouchEventActivity
import com.android.ui.view.ViewActivity
import com.android.ui.viewpager.ViewPagerActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val items = arrayOf(
        "TouchEventActivity（触摸时间分发机制）",
        "TextActivity（绘制文本）",
        "ViewPagerActivity（ViewPager相关）",
        "CalculatorActivity（利用设计模式设计简单计算器）",
        "PartActivity（透明Activity实现弹出界面占屏幕一部分）",
        "ViewActivity（自定义View使用）",
        "ZipActivity（动态加载资源换肤）",
        "Animation（动画）",
        "RecorderActivity（仿微信发送语音）",
        "BehaviorActivity（CoordinatorLayout的Behavior）",
        "SheetDialogActivity（Behavior的使用）",
        "NestedScrollActivity（NestedScroll的嵌套使用）",
        "PathActivity（Path的使用）",
        "CollapseActivity（Collapse的使用）",
        "TabLayoutActivity（TabLayout的使用）"
    )
    val activities = arrayOf(
        TouchEventActivity::class.java,
        TextActivity::class.java,
        ViewPagerActivity::class.java,
        CalculatorActivity::class.java,
        PartActivity::class.java,
        ViewActivity::class.java,
        ZipActivity::class.java,
        MotionLayoutActivity::class.java,
        RecorderActivity::class.java,
        SetCarLocationActivity::class.java,
        BottomSheetActivity::class.java,
        NestedScrollActivity::class.java,
        PathActivity::class.java,
        CollapseActivity::class.java,
        TabLayoutActivity::class.java


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager = LinearLayoutManager(this)
        recyclerview.setLayoutManager(layoutManager);
        val itemAdapter =
            ItemAdapter(this, items.asList())
        recyclerview.setAdapter(itemAdapter)
        recyclerview.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                DividerItemDecoration.VERTICAL_LIST
            )
        )
        itemAdapter.setOnItemClickLitener(object : ItemAdapter.OnItemClickLitener {
            override fun onItemClick(v: View) {
                val position = recyclerview.getChildAdapterPosition(v)
                startActivity(Intent(this@MainActivity, activities[position]))
            }
        })
    }

}
