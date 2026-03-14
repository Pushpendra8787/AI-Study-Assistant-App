package com.knowzy.app.splash;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class ParticleNetworkView extends View {

    private static final int PARTICLE_COUNT = 18;

    private float[] x = new float[PARTICLE_COUNT];
    private float[] y = new float[PARTICLE_COUNT];

    private Paint particlePaint = new Paint();
    private Paint linePaint = new Paint();

    private Random random = new Random();

    public ParticleNetworkView(Context context, AttributeSet attrs) {
        super(context, attrs);

        particlePaint.setColor(0x88FFFFFF);
        particlePaint.setAntiAlias(true);

        linePaint.setColor(0x33FFFFFF);
        linePaint.setStrokeWidth(2);

        for (int i = 0; i < PARTICLE_COUNT; i++) {
            x[i] = random.nextInt(1000);
            y[i] = random.nextInt(1800);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        for (int i = 0; i < PARTICLE_COUNT; i++) {

            y[i] -= 0.5f;

            if (y[i] < 0)
                y[i] = getHeight();

            canvas.drawCircle(x[i], y[i], 5, particlePaint);
        }

        for (int i = 0; i < PARTICLE_COUNT; i++) {

            for (int j = i + 1; j < PARTICLE_COUNT; j++) {

                float dx = x[i] - x[j];
                float dy = y[i] - y[j];

                float distance = (float) Math.sqrt(dx * dx + dy * dy);

                if (distance < 220)
                    canvas.drawLine(x[i], y[i], x[j], y[j], linePaint);
            }
        }

        invalidate();
    }
}