package com.android.customview.calculator;

/**
 * 加
 *
 * @author Administrator
 */
public class OperationAdd extends Operation {
    @Override
    public int getResult() {
        return getX() + getY();
    }
}