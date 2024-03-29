package com.android.ui.path.waterwave;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.android.ui.R;


public class WaterWaveAttrInit {

    private final int progressWidth; // 进度条宽度
    private final int progressColor;
    private final int progressBgColor;
    private final int waterWaveColor;
    private final int waterWaveBgColor;
    private final int progress2WaterWidth; // 进度条和水波之间的间距
    private final boolean showProgress; // 是否显示进度条
    private final boolean showNumerical; // 是否显示百分比
    private final int fontSize;
    private final int textColor;
    private final int progress;
    private final int maxProgress;

    @SuppressLint("Recycle")
    public WaterWaveAttrInit(Context context, AttributeSet attrs, int defStyle) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.WaterWaveProgress, defStyle, 0);
        progressWidth = typedArray.getDimensionPixelOffset(
                R.styleable.WaterWaveProgress_progressWidth, 0);
        progressColor = typedArray.getColor(
                R.styleable.WaterWaveProgress_progressColor, 0xFF33B5E5);
        progressBgColor = typedArray.getColor(
                R.styleable.WaterWaveProgress_progressBgColor, 0xFFBEBEBE);
        waterWaveColor = typedArray.getColor(
                R.styleable.WaterWaveProgress_waterWaveColor, 0XFF4BBDFE);
        waterWaveBgColor = typedArray.getColor(
                R.styleable.WaterWaveProgress_waterWaveBgColor, 0xFFDDDDDD);
        progress2WaterWidth = typedArray.getDimensionPixelOffset(
                R.styleable.WaterWaveProgress_progress2WaterWidth, 0);
        showProgress = typedArray.getBoolean(
                R.styleable.WaterWaveProgress_showProgress, true);
        showNumerical = typedArray.getBoolean(
                R.styleable.WaterWaveProgress_showNumerical, true);
        fontSize = typedArray.getDimensionPixelOffset(
                R.styleable.WaterWaveProgress_fontSize, 0);
        textColor = typedArray.getColor(
                R.styleable.WaterWaveProgress_textColor, 0xFFFFFFFF);
        progress = typedArray.getInteger(
                R.styleable.WaterWaveProgress_progress, 15);
        maxProgress = typedArray.getInteger(
                R.styleable.WaterWaveProgress_maxProgress, 100);
        typedArray.recycle();
    }

    public int getProgressWidth() {
        return progressWidth;
    }

    public int getProgressColor() {
        return progressColor;
    }

    public int getProgressBgColor() {
        return progressBgColor;
    }

    public int getWaterWaveColor() {
        return waterWaveColor;
    }

    public int getWaterWaveBgColor() {
        return waterWaveBgColor;
    }

    public int getProgress2WaterWidth() {
        return progress2WaterWidth;
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    public boolean isShowNumerical() {
        return showNumerical;
    }

    public int getFontSize() {
        return fontSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getProgress() {
        return progress;
    }

    public int getMaxProgress() {
        return maxProgress;
    }

}
