package com.android.ui.view.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;

/**
 * 闪闪发光的字体
 * Created by Alex_Mahao on 2016/3/14.
 */
public class FlickTextView extends androidx.appcompat.widget.AppCompatTextView {


    private int mViewWidth;

    private Paint mPaint;

    /**
     * 颜色选软启
     */
    private LinearGradient mLinearGradient;

    private Matrix mGradientMatrix;

    private float mTranslate;


    public FlickTextView(Context context) {
        super(context, null);
    }

    public FlickTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();

            if (mViewWidth > 0) {
                mPaint = getPaint();
// 第一个,第二个参数表示渐变起点 可以设置起点终点在对角等任意位置
// 第三个,第四个参数表示渐变终点
// 第五个参数表示渐变颜色
// 第六个参数可以为空,表示坐标,值为0-1 new float[] {0.25f, 0.5f, 0.75f, 1 }
// 如果这是空的，颜色均匀分布，沿梯度线。
// 第七个表示平铺方式
// CLAMP重复最后一个颜色至最后
// MIRROR重复着色的图像水平或垂直方向已镜像方式填充会有翻转效果
// REPEAT重复着色的图像水平或垂直方向
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0,
                        new int[]{Color.BLUE, 0XFFFFFFFF, Color.BLUE},
                        null, Shader.TileMode.CLAMP);

                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }
//在onDraw()方法中进行改变Matrix对象，并设置给渲染器，同时刷新试图，形成循环。
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null) {
            //每次移动的1/5宽
            mTranslate += mViewWidth / 5;

            //当该控件渲染器的颜色变化正好移除屏幕时，从左侧进入
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            //在指定矩阵上渲染
            mLinearGradient.setLocalMatrix(mGradientMatrix);

            //100ms 后继续刷新试图，即调用onDraw()方法。
            postInvalidateDelayed(100);
        }
    }
}