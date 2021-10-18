package com.usu.balldrop;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball extends GameObject {
    float x;
    float y;
    float velY;
    float velX;
    float radius;
    int screenHeight;
    int screenWidth;
    int color;
    float totalDelta = 0;
    public Ball(float x, float y, int screenHeight, int screenWidth) {
        this.x = x;
        this.y = y;
        velY = 0f;
        velX = 0f;
        radius = 40;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        color = Color.BLUE;
    }

    @Override
    public void update(float deltaT) {
        totalDelta += deltaT;
        velY = velY + ((9.8f * 9.8f) * deltaT);
        y = y + velY;
        x = x + velX;

        color = Color.rgb(100, 100, (totalDelta ) % 256);

        if (y - radius < 0) {
            y = radius;
            velY = -velY - 5f;
        }
        if (y + radius > screenHeight) {
            y = screenHeight - radius;
            velY = -velY + 5f;
        }
        if (x - radius < 0) {
            x = radius;
            velX = -velX - 5f;
        }
        if (x + radius > screenWidth) {
            x = screenWidth - radius;
            velX = -velX + 5f;
        }

    }

    public void addRandomForce() {
        velX = (float)(Math.random() * 1000 - 500);
        velY = (float)(Math.random() * 1000 - 1000);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        canvas.drawCircle(x, y, radius, paint);
        paint.reset();
    }
}
