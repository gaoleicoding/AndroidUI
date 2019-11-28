package com.android.customview.recorder;

import android.Manifest;
import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.customview.R;
import com.android.customview.recorder.manager.MediaManager;
import com.android.customview.recorder.view.AudioRecorderButton;
import com.android.customview.recorder.view.Recorder;
import com.android.customview.recorder.view.RecorderAdapter;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;


public class RecorderActivity extends AppCompatActivity {
    private String TAG = "RecorderActivity";

    private ListView mListView;
    private ArrayAdapter<Recorder> mAdapter;
    private List<Recorder> mDatas = new ArrayList<>();

    private View mAnimView;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder);


        initView();
        setListViewAdapter();

        new RxPermissions(this).requestEach(
                Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
                .subscribe(permission -> {
                    if (permission.granted) {
                        // 用户已经同意该权限
                        Log.e(TAG, "1");
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // 用户拒绝了该权限，那么下次再次启动时，还会提示请求权限的对话框
                        Log.e(TAG, "2");
                    } else {
                        // 用户拒绝了该权限，并且选中『不再询问』
                        Log.e(TAG, "3");
                    }
                });
    }

    private void initView() {
        mListView = findViewById(R.id.id_listview);
        AudioRecorderButton mAudioRecorderButton = findViewById(R.id.id_recorder_button);

        mAudioRecorderButton.setAudioFinishRecorderListener((seconds, filePath) -> {
            //每完成一次录音
            Recorder recorder = new Recorder(seconds, filePath);
            mDatas.add(recorder);
            //更新adapter
            mAdapter.notifyDataSetChanged();
            //设置listview 位置
            mListView.setSelection(mDatas.size() - 1);
        });
    }

    private void setListViewAdapter() {
        mAdapter = new RecorderAdapter(this, mDatas);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener((parent, view, position, id) -> {
            //如果第一个动画正在运行， 停止第一个播放其他的
            if (mAnimView != null) {
                mAnimView.setBackgroundResource(R.drawable.adj);
                mAnimView = null;
            }
            //播放动画
            mAnimView = view.findViewById(R.id.id_recorder_anim);
            mAnimView.setBackgroundResource(R.drawable.play_anim);
            AnimationDrawable animation = (AnimationDrawable) mAnimView.getBackground();
            animation.start();

            //播放音频  完成后改回原来的background
            MediaManager.getInstance().playSound(mDatas.get(position).getFilePath(), mp -> {
                mAnimView.setBackgroundResource(R.drawable.adj);
                MediaManager.getInstance().pause();
            });
        });
    }

    /**
     * 根据生命周期 管理播放录音
     */
    @Override
    protected void onPause() {
        super.onPause();
        MediaManager.getInstance().pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MediaManager.getInstance().resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MediaManager.getInstance().release();
    }


}
