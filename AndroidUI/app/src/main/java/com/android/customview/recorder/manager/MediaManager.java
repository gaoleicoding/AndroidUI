package com.android.customview.recorder.manager;

import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by Administrator on 2017/11/28.
 * 播放录音类
 */

public class MediaManager {
    private static MediaPlayer mMediaPlayer;

    private static boolean isPause;
    private static MediaManager mInstance;
    private final String onlineAudio="https://github.com/gaoleicoding/CustomView/raw/master/CustomView/11281706.mp3";

    private MediaManager() {
    }

    public static MediaManager getInstance() {
        if (mInstance == null) {
            synchronized (MediaManager.class) {
                if (mInstance == null) {
                    mInstance = new MediaManager();
                    mMediaPlayer = new MediaPlayer();
                }
            }
        }
        return mInstance;
    }

    //播放录音
    public void playSound(String filePath, MediaPlayer.OnCompletionListener onCompletionListener) {
        if (mMediaPlayer == null) {
            //播放错误 防止崩溃
            mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    mMediaPlayer.reset();
                    return false;
                }
            });
        } else {
            mMediaPlayer.reset();
        }
        try {
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setOnCompletionListener(onCompletionListener);
            mMediaPlayer.setDataSource(onlineAudio);
            mMediaPlayer.prepare();
            mMediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 如果 播放时间过长,如30秒
     * 用户突然来电话了,则需要暂停
     */
    public void pause() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            isPause = true;
        }
    }

    /**
     * 播放
     */
    public void resume() {
        if (mMediaPlayer != null && isPause) {
            mMediaPlayer.start();
            isPause = false;
        }
    }

    /**
     * activity 被销毁  释放
     */
    public void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
//            mMediaPlayer = null;
        }
    }
}
