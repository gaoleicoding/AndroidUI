package com.android.customview.calculator;

public class OptionerFactory2 {
    public static <T extends Operation> T creatOperation(Class<T> clz) {
        Operation operation = null;
        try {
            operation = (Operation) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {

        }
        return (T) operation;
    }
}