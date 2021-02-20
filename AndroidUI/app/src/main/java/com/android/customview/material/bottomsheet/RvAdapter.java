package com.android.customview.material.bottomsheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.customview.R;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {

    private List<String> mList;

    public RvAdapter(List<String> list) {
        mList = list;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.dialog_bottom_sheet_item, viewGroup, false);
        return new RvViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class RvViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        RvViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(android.R.id.text1);
        }
    }

}
