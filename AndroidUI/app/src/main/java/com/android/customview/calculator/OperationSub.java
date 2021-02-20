package com.android.customview.calculator;
/**
 * 减
 * @author Administrator
 *
 */
public class OperationSub extends Operation{
	@Override
	public int getResult() {
		return getX()-getY();
	}
}