package com.usu.ondraw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle {
    int strokeColor;
    int fillColor;
    float x;
    float y;
    int radius;
    public Circle(int strokeColor, int fillColor, float x, float y, int radius) {
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(strokeColor);
        paint.setStrokeWidth(8);
        canvas.drawCircle(x, y, radius, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(fillColor);
        canvas.drawCircle(x, y, radius - 8, paint);
        paint.reset();
    }
}
