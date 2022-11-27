package com.android.ui.view;

import android.app.Activity;
import android.os.Bundle;

import com.android.ui.R;
import com.android.ui.view.custom.MyAdapter;
import com.android.ui.view.custom.MyListView;

import java.util.ArrayList;
import java.util.List;

public class CustomActivity extends Activity {

    private MyAdapter adapter;

    private final List<String> contentList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        initList();
        MyListView myListView = findViewById(R.id.my_list_view);
        myListView.setOnDeleteListener(index -> {
            contentList.remove(index);
            adapter.notifyDataSetChanged();
        });
        adapter = new MyAdapter(this, 0, contentList);
        myListView.setAdapter(adapter);
    }

    private void initList() {
        contentList.add("Content Item 1");
        contentList.add("Content Item 2");
        contentList.add("Content Item 3");
        contentList.add("Content Item 4");
        contentList.add("Content Item 5");
        contentList.add("Content Item 6");
        contentList.add("Content Item 7");
        contentList.add("Content Item 8");
        contentList.add("Content Item 9");
        contentList.add("Content Item 10");
        contentList.add("Content Item 11");
        contentList.add("Content Item 12");
        contentList.add("Content Item 13");
        contentList.add("Content Item 14");
        contentList.add("Content Item 15");
        contentList.add("Content Item 16");
        contentList.add("Content Item 17");
        contentList.add("Content Item 18");
        contentList.add("Content Item 19");
        contentList.add("Content Item 20");
    }
}