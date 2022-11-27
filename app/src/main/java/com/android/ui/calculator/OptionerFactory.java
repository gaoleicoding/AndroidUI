package com.android.ui.calculator;

public class OptionerFactory {
    public static Operation creatOperation(String oper) {
        Operation operation = null;
        switch (oper) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
        }
        return operation;
    }
}