package com.usu.balldrop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball extends GameObject {
    float x;
    float y;
    float velY;
    float radius;
    int screenHeight;
    public Ball(float x, float y, int screenHeight) {
        this.x = x;
        this.y = y;
        velY = 0f;
        radius = 40;
        this.screenHeight = screenHeight;
    }

    @Override
    public void update(float deltaT) {
        velY = velY + ((9.8f * 9.8f) * deltaT);
        y = y + velY;

        if (y + radius > screenHeight) {
            y = screenHeight - radius;
            velY = -velY + 5f;
        }
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLUE);
        canvas.drawCircle(x, y, radius, paint);
        paint.reset();
    }
}
