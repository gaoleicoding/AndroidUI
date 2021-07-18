package com.android.ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity extends Activity {
      @Override 
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(new SampleView(this));
      }
      private static class SampleView extends View {
            private static final int LAYER_FLAGS = Canvas.ALL_SAVE_FLAG;

            private Paint mPaint;
            public SampleView(Context context) {
                  super(context);
                  setFocusable(true);
                  mPaint = new Paint();
                  mPaint.setAntiAlias(true);
            }
            @Override
            protected void onDraw(Canvas canvas) {
                  canvas.drawColor(Color.WHITE);
                  canvas.translate(10, 10);
                  mPaint.setColor(Color.RED);
                  canvas.drawCircle(75, 75, 75, mPaint);
//                  saveLayer的时候都会新建一个透明的图层（离屏Bitmap-离屏缓冲），并且会将saveLayer之前的一些Canvas操作延续过来
//                  后续的绘图操作都在新建的layer上面进行 当我们调用restore 或者 restoreToCount 时 更新到对应的图层和画布上
                  canvas.saveLayerAlpha(0, 0, 200, 200, 0x88, LAYER_FLAGS);
                  mPaint.setColor(Color.BLUE); 
                  canvas.drawCircle(125, 125, 75, mPaint); 
                  canvas.restore();
            }
      }
}