package com.android.customview.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.customview.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class TestBottomSheetDialogFragment extends DialogFragment {

    private BottomSheetBehavior<FrameLayout> behavior;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //返回BottomSheetDialog的实例
        return new BottomSheetDialog(this.getContext());
    }

    @Override
    public void onStart() {
        super.onStart();
        BottomSheetDialog dialog = (BottomSheetDialog) getDialog();
        //注意控件id别搞错
        FrameLayout bottomSheet =
                dialog.getDelegate().findViewById(R.id.design_bottom_sheet);
        if (bottomSheet != null) {
            CoordinatorLayout.LayoutParams layoutParams =
                    (CoordinatorLayout.LayoutParams) bottomSheet.getLayoutParams();
            //设置弹窗最大高度
            layoutParams.height = getPeekHeight();
            bottomSheet.setLayoutParams(layoutParams);
            behavior = BottomSheetBehavior.from(bottomSheet);
            //peekHeight即弹窗的最大高度
            behavior.setPeekHeight(getPeekHeight());
            // 初始为展开状态
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    /**
     * 弹窗高度，默认为屏幕高度的四分之三
     * 子类可重写该方法返回peekHeight
     *
     * @return height
     */
    protected int getPeekHeight() {
        int peekHeight = getResources().getDisplayMetrics().heightPixels;
        //设置弹窗高度为屏幕高度的3/4
        return peekHeight - peekHeight / 3;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_bottom_sheet, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        RvAdapter adapter = new RvAdapter(getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext()
                , LinearLayoutManager.VERTICAL));
        view.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDialog();
            }
        });
        return view;
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("this is item in " + i);
        }
        return list;
    }
    public void closeDialog()
    {
        //点击任意布局关闭
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }
}
