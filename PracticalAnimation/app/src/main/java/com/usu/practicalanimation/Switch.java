package com.usu.practicalanimation;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.renderscript.Sampler;
import android.view.MotionEvent;
import android.view.View;

public class Switch extends View {
    int width = 200;
    int height = 80;
    int cx;
    int state = 0;
    Paint paint = new Paint();
    ValueAnimator animator;
    public Switch(Context context) {
        super(context);
        cx = state == 0 ? 16 + (height / 2) : state == 1 ? 16 + width / 2 : 16 + width - (height / 2);
        setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                state = state + 1;
                if (state > 2) {
                    state = 0;
                }
                startAnimation();
                return true;
            }
            return false;
        });
    }

    private void startAnimation() {
        if (animator != null) {
            animator.cancel();
        }

//        int to;
//        if (state == 0) {
//            to = 16 + (height / 2);
//        } else if (state == 1) {
//            to = 16 + width / 2;
//        } else {
//            to = 16 + width - (height / 2);
//        }

        int to = state == 0 ? 16 + (height / 2) : state == 1 ? 16 + width / 2 : 16 + width - (height / 2);

        animator = ValueAnimator.ofInt(
                cx, // from
                to
        );

        animator.setDuration(80);
        animator.addUpdateListener(animator -> {
            cx = (int)animator.getAnimatedValue();
            invalidate();
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        canvas.drawRoundRect(16,16, 16 + width, 16 + height,  height / 2, height / 2, paint);

        paint.reset();
        paint.setColor(Color.CYAN);
        canvas.drawCircle(cx, 16 + (height / 2), (height / 2), paint);
        paint.reset();
    }
}
