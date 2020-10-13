package com.android.customview.view.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.android.customview.R;

import java.lang.reflect.Field;

/**
 * 外描边
 */
public class OuterStrokeTextView extends androidx.appcompat.widget.AppCompatTextView {
    private Field colorField;
    private int textColor;
    private int outlineColor;
    private int outlineWidth;

    public OuterStrokeTextView(Context context) {
        this(context, null);
    }

    public OuterStrokeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public OuterStrokeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        try {
            colorField = TextView.class.getDeclaredField("mCurTextColor");
            colorField.setAccessible(true);

            // If the reflection fails (which really shouldn't happen), we
            // won't need the rest of this stuff, so we keep it in the try-catch

            textColor = getTextColors().getDefaultColor();

            // These can be changed to hard-coded default
            // values if you don't need to use XML attributes

            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.OuterStrokeTextView);
            outlineColor = a.getColor(R.styleable.OuterStrokeTextView_outlineColor, Color.TRANSPARENT);
            outlineWidth = a.getDimensionPixelSize(R.styleable.OuterStrokeTextView_outlineWidth, 0);
            a.recycle();
        } catch (NoSuchFieldException e) {
            // Optionally catch Exception and remove print after testing
            e.printStackTrace();
            colorField = null;
        }
    }

    @Override
    public void setTextColor(int color) {
        // We want to track this ourselves
        // The super call will invalidate()

        textColor = color;
        super.setTextColor(color);
    }

    public void setOutlineColor(int color) {
        outlineColor = color;
        invalidate();
    }

    private void setOutlineStrokeWidth(float width) {
        getPaint().setStrokeWidth(width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // If we couldn't get the Field, then we
        // need to skip this, and just draw as usual

        if (colorField != null) {
            int currentTextColor = getCurrentTextColor();
            // Outline
//            setColorField(outlineColor);
            getPaint().setStyle(Paint.Style.STROKE);
            getPaint().setStrokeWidth(outlineWidth);
            setTextColor(outlineColor);
//            getPaint().setShadowLayer(6, 0, 0, Color.RED);
//            getPaint().setMaskFilter(new BlurMaskFilter(5, BlurMaskFilter.Blur.NORMAL));
            super.onDraw(canvas);

            // Reset for text
            setTextColor(currentTextColor);
            getPaint().setStyle(Paint.Style.FILL);
            super.onDraw(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    private void setColorField(int color) {
        // We did the null check in onDraw()
        try {
            colorField.setInt(this, color);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            // Optionally catch Exception and remove print after testing
            e.printStackTrace();
        }
    }

    // Optional saved state stuff

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.textColor = textColor;
        ss.outlineColor = outlineColor;
        ss.outlineWidth = getPaint().getStrokeWidth();
        return ss;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        textColor = ss.textColor;
        outlineColor = ss.outlineColor;
        getPaint().setStrokeWidth(ss.outlineWidth);
    }

    private static class SavedState extends BaseSavedState {
        int textColor;
        int outlineColor;
        float outlineWidth;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            textColor = in.readInt();
            outlineColor = in.readInt();
            outlineWidth = in.readFloat();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(textColor);
            out.writeInt(outlineColor);
            out.writeFloat(outlineWidth);
        }

        public static final Parcelable.Creator<SavedState>
                CREATOR = new Parcelable.Creator<SavedState>() {

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }

    public static int dpToPx(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}