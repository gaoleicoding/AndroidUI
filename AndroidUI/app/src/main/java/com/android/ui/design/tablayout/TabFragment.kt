package com.android.ui.design.tablayout

import android.view.View
import android.widget.TextView
import com.android.ui.R


class TabFragment : BaseFragment() {

    lateinit var mTVContent: TextView
    lateinit var title: String

    override fun getContentViewId(): Int {
        return R.layout.fragment_tab
    }

    fun setContent(title: String) {
       this.title=title
    }

    override fun initView(view: View) {
        mTVContent = view.findViewById(R.id.tv_content)
        mTVContent.setText(title)
    }

    override fun initData() {
    }

}