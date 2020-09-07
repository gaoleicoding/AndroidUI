package com.android.customview.material.behavior2;

import androidx.annotation.Nullable;

import com.android.customview.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

/**
 * GaodeAdapter
 *
 * @author: 17040880
 * @time: 2017/9/19 17:16
 */
class GaodeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public GaodeAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_schedule_view,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_schedule_adapter_name,item);
    }
}
