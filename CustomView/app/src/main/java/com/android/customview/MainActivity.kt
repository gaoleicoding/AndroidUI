package com.android.customview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.customview.activitypart.PartActivity
import com.android.customview.adapter.DividerItemDecoration
import com.android.customview.adapter.ItemAdapter
import com.android.customview.animation.AnimationActivity
import com.android.customview.calculator.CalculatorActivity
import com.android.customview.recorder.RecorderActivity
import com.android.customview.skin.ZipActivity
import com.android.customview.touchevent.DispatchActivity
import com.android.customview.touchevent.TextActivity
import com.android.customview.view.StyleActivity
import com.android.customview.viewpager.ViewpagerActivity2
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val items = arrayOf(
        "DispatchActivity（触摸时间分发机制解析）",
        "TextActivity（绘制文本解析）",
        "InfiniteViewPagerActivity（无限循环ViewPager解析）",
        "CalculatorActivity（利用设计模式设计简单计算器解析）",
        "PartActivity（透明Activity实现弹出界面占屏幕一部分解析）",
        "StyleActivity（Style使用）",
        "ZipActivity（动态加载资源换肤）",
        "Animation（动画）",
        "RecorderActivity（仿微信发送语音解析）"

    )
    val activities = arrayOf(
        DispatchActivity::class.java,
        TextActivity::class.java,
        ViewpagerActivity2::class.java,
        CalculatorActivity::class.java,
        PartActivity::class.java,
        StyleActivity::class.java,
        ZipActivity::class.java,
        AnimationActivity::class.java,
        RecorderActivity::class.java

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var layoutManager = LinearLayoutManager(this)
        recyclerview.setLayoutManager(layoutManager);
        var itemAdapter =
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
                var position = recyclerview.getChildAdapterPosition(v)
                startActivity(Intent(this@MainActivity, activities[position]))
            }
        })
    }

}
