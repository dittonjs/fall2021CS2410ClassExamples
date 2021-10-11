package com.usu.ondraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {
    Paint paint = new Paint();
    float width;
    float height;
    public DrawingView(Context context) {
        super(context);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(width / 2, height / 2);
        canvas.rotate(45);
        canvas.drawRect(
                - 50,
                - 50,
                + 50,
                + 50,
                paint
        );
        canvas.restore();

        canvas.drawRect(
                - 50,
                - 50,
                + 50,
                + 50,
                paint
        );

    }
}
