package com.android.customview.calculator;

/**
 * 乘
 *
 * @author Administrator
 */
public class OperationMul extends Operation {
    @Override
    public int getResult() {
        return getX() * getY();
    }
}