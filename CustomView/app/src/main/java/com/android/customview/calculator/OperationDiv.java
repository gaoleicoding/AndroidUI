package com.android.customview.calculator;

/**
 * 除
 *
 * @author Administrator
 */
public class OperationDiv extends Operation {
    @Override
    public int getResult() {
        if (getY() == 0) {
            System.out.println("除数不能为0");
            return -1;
        } else {
            return getX() / getY();
        }
    }
}