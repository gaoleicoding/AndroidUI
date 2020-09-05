package com.android.customview.util;

import android.util.Log;

public class SDKLog {

    private static final String TAG = "CustomViewLog";

    // SDK日志本地开关
    // 通过命令行控制，SDK日志打开命令：
    // adb shell setprop log.tag.CustomViewLog VERBOSE
    private static boolean sVerboseLoggable = Log.isLoggable(TAG, Log.VERBOSE);
    // adb shell setprop log.tag.CustomViewLog DEBUG
    private static boolean sDebugLoggable = Log.isLoggable(TAG, Log.DEBUG);

    private static int sLevel = Log.ERROR;

    public static boolean isVerboseLoggable(){
        return sVerboseLoggable || sLevel <= Log.VERBOSE;
    }

    public static boolean isDebugLoggable(){
        return sDebugLoggable || sLevel <= Log.DEBUG;
    }

    public static void setLevel(int level) {
        sLevel = level;
    }

    public static int getLevel() {
        return sLevel;
    }

    public static void v(String tag, String msg) {
        if (isVerboseLoggable()) {
            Log.v(tag, msg);
        }
    }

    public static void v(String tag, String msg, Throwable tr) {
        if (isVerboseLoggable()) {
            Log.v(tag, msg, tr);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebugLoggable()) {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (isDebugLoggable()) {
            Log.d(tag, msg, tr);
        }
    }

    public static void i(String tag, String msg) {
        if (sLevel <= Log.INFO) {
            Log.i(tag, msg);
        }
    }

    public static void i(String tag, String msg, Throwable tr) {
        if (sLevel <= Log.INFO) {
            Log.i(tag, msg, tr);
        }
    }

    public static void w(String tag, String msg) {
        if (sLevel <= Log.WARN) {
            Log.w(tag, msg);
        }
    }

    public static void w(String tag, String msg, Throwable tr) {
        if (sLevel <= Log.WARN) {
            Log.w(tag, msg, tr);
        }
    }

    public static void e(String tag, String msg) {
        if (sLevel <= Log.ERROR) {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (sLevel <= Log.ERROR) {
            Log.e(tag, msg, tr);
        }
    }
}
