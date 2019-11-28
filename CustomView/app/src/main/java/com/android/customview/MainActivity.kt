package com.android.customview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.customview.activitypart.PartActivity
import com.android.customview.adapter.DividerItemDecoration
import com.android.customview.adapter.ItemAdapter
import com.android.customview.calculator.CalculatorActivity
import com.android.customview.touchevent.DispatchActivity
import com.android.customview.touchevent.TextActivity
import com.android.customview.viewpager.ViewpagerActivity2
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val items = arrayOf(
        "DispatchActivity",
        "TextActivity",
        "InfiniteViewPager",
        "Calculator",
        "ActivityPart"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var layoutManager = LinearLayoutManager(this)
        recyclerview.setLayoutManager(layoutManager);
        var itemAdapter = ItemAdapter(this, items.asList())
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
                when (position) {
                    0 -> startActivity(Intent(this@MainActivity, DispatchActivity::class.java))
                    1 -> startActivity(Intent(this@MainActivity, TextActivity::class.java))
                    2 -> startActivity(Intent(this@MainActivity, ViewpagerActivity2::class.java))
                    3 -> startActivity(Intent(this@MainActivity, CalculatorActivity::class.java))
                    4 -> startActivity(Intent(this@MainActivity, PartActivity::class.java))
                }
            }
        })
    }

}
