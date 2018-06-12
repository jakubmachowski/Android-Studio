package com.example.jmach.paint;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PaintView extends SurfaceView implements SurfaceHolder.Callback {
    ArrayList<ObiektDoNarysowania> punkty;
    Paint paint;
    private int color;

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        punkty = new ArrayList<ObiektDoNarysowania>();
        paint = new Paint();
        color = Color.RED;
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        RectF oval = new RectF(event.getX() - 50, event.getY() - 50, event.getX() + 50, event.getY() + 50);
        punkty.add(new ObiektDoNarysowania(color, oval));
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (ObiektDoNarysowania punkt : punkty) {
            paint.setColor(punkt.kolor);
            canvas.drawOval(punkt.figura, paint);
        }
    }

    public void setColor(int color) {
        this.color = color;
    }

}