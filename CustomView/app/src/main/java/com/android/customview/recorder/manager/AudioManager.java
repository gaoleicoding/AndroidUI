package com.android.customview.recorder.manager;

import android.media.MediaRecorder;

import com.android.customview.util.ContextUtil;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/28.
 * <p>
 * 录音管理类
 */

public class AudioManager {

    private static MediaRecorder mMediaRecorder;
    private static AudioManager mInstance;
    private boolean isPrepared;
    private String mCurrentFilePath;

    private String mDir = ContextUtil.getAppContext().getExternalCacheDir().getPath() + "/chat_audios";


    private AudioManager() {
    }



    public static AudioManager getInstance() {
        if (mInstance == null) {
            synchronized (AudioManager.class) {
                if (mInstance == null) {
                    mInstance = new AudioManager();

                }
            }
        }
        return mInstance;
    }


    /**
     * 准备
     */
    public void prepareAudio() {
        try {
            //每次录制都需要创建新对象，不然会报错IllegalStateException，关于音频的状态
            mMediaRecorder = new MediaRecorder();
            File dir = new File(mDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String fileName = generateFileName();

            File file = new File(dir, fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            mCurrentFilePath = file.getAbsolutePath();

//            if (!isPrepared) {
                //设置输出文件
                mMediaRecorder.setOutputFile(file.getAbsolutePath());
                //设置MediaRecorder的音频源为麦克风
                mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                //设置音频格式
                mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AAC_ADTS);
                //设置音频的格式为amr
                mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
                //设置录制的音频编码比特率
//            mMediaRecorder.setAudioEncodingBitRate();
                // 设置录制的音频采样率
//            mMediaRecorder.setAudioSamplingRate();

                mMediaRecorder.prepare();
//            }
            mMediaRecorder.start();
            //准备结束
            isPrepared = true;
            if (mListener != null) {
                mListener.wellPrepared();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    生成UUID唯一标示符
//    算法的核心思想是结合机器的网卡、当地时间、一个随即数来生成GUID
//    .amr音频文件
    private String generateFileName() {
        return UUID.randomUUID().toString() + ".aac";
    }

    public int getVoiceLevel(int maxLevel) {
        if (isPrepared) {
            //获得最大的振幅getMaxAmplitude() 1-32767
            try {
                return maxLevel * mMediaRecorder.getMaxAmplitude() / 32768 + 1;
            } catch (Exception e) {

            }
        }
        return 1;
    }

    public void release() {
        mMediaRecorder.release();
        mMediaRecorder = null;
    }

    public void cancel() {
        release();
        if (mCurrentFilePath != null) {
            File file = new File(mCurrentFilePath);
            file.delete();
            mCurrentFilePath = null;
        }
    }

    public String getCurrentFilePath() {
        return mCurrentFilePath;
    }


    /**
     * 回调准备完毕
     */
    public interface AudioStateListener {
        void wellPrepared();
    }

    private AudioStateListener mListener;

    public void setOnAudioStateListener(AudioStateListener listener) {
        mListener = listener;
    }
}

