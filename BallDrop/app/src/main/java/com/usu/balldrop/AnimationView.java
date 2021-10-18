package com.usu.balldrop;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class AnimationView extends View {
    int radius = 10;
    Paint paint = new Paint();
    public AnimationView(Context context) {
        super(context);
        ValueAnimator animator = ValueAnimator.ofInt(10, 500);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                radius = (int)valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.rgb(radius % 200, 100, radius % 256));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);

    }
}
