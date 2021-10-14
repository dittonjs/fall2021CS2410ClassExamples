package com.usu.balldrop;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class GameObject {
    public abstract void update(float deltaT);

    public abstract void draw(Canvas canvas, Paint paint);
}
