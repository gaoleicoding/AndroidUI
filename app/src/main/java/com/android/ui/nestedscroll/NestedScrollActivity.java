package com.android.ui.nestedscroll;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.ui.R;


public class NestedScrollActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nestedscroll);

        RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View item = LayoutInflater.from(NestedScrollActivity.this)
                        .inflate(R.layout.recyclerview_item, parent, false);
                return new Holder(item);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                Holder h = (Holder) holder;
                h.textView.setText("item " + position);
            }

            @Override
            public int getItemCount() {
                return 100;
            }

            class Holder extends RecyclerView.ViewHolder {
                TextView textView;

                public Holder(View itemView) {
                    super(itemView);
                    textView = (TextView) itemView.findViewById(R.id.text);
                }
            }
        });
    }
}
