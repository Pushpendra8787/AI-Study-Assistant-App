package com.knowzy.app.splash;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BrainPulseView extends View {

    private Paint paint = new Paint();
    private float radius = 120;

    public BrainPulseView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setColor(0x44FFFFFF);
        paint.setStyle(Paint.Style.FILL);

        startPulse();
    }

    private void startPulse() {

        ValueAnimator animator = ValueAnimator.ofFloat(100, 160);

        animator.setDuration(1800);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);

        animator.addUpdateListener(animation -> {

            radius = (float) animation.getAnimatedValue();
            invalidate();

        });

        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);

    }
}