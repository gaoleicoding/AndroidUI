package com.android.ui.design.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    val TAG: String = javaClass.simpleName
    private var isFirstLoad = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getContentViewId(), container, false)
        initView(view)
        return view
    }

    override fun onResume() {
        super.onResume()
        if (isFirstLoad) {
            isFirstLoad = false
            initData()
        }
    }

    abstract fun getContentViewId(): Int
    abstract fun initView(view: View)
    abstract fun initData()

}