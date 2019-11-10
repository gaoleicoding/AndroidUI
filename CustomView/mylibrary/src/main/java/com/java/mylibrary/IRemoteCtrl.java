package com.java.mylibrary;

import android.content.Context;

public interface IRemoteCtrl {
/**
 * 显示
 */
public void showWindow();

/**
 * 隐藏
 */
public void hideWindow();

/**
 * 状态监听
 */
public void enterPage(String page);
}