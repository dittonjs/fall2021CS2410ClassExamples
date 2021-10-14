package com.usu.balldrop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class GameView extends View implements Choreographer.FrameCallback {

    long time;
    Paint paint = new Paint();
    ArrayList<GameObject> gameObjects = new ArrayList<>();

    public GameView(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        time = System.nanoTime();
        setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                gameObjects.add(new Ball(motionEvent.getX(), motionEvent.getY(), getHeight()));
                return true;
            }
            return false;
        });
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        gameObjects.forEach(go -> {
            go.draw(canvas, paint);
        });
    }

    @Override
    public void doFrame(long l) {
        // update
        long deltaT = l - time;
        time = l;
        gameObjects.forEach(go -> {
            go.update(deltaT / 1000000000f);
        });

        Choreographer.getInstance().postFrameCallback(this);
        invalidate();
    }
}
