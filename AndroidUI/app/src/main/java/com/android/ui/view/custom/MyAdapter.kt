package com.android.ui.view.custom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.android.ui.R

class MyAdapter(context: Context?, textViewResourceId: Int, objects: List<String?>?) :
    ArrayAdapter<String?>(
        context!!, textViewResourceId, objects!!
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        view = convertView ?: LayoutInflater.from(context).inflate(R.layout.my_listview_item, null)
        val textView = view.findViewById<View>(R.id.text_view) as TextView
        textView.text = getItem(position)
        return view
    }
}