package com.knowzy.app.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class ReflectionView extends AppCompatImageView {

    public ReflectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDrawingCacheEnabled(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        Bitmap original = getDrawingCache();

        if (original == null) return;

        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);

        Bitmap reflection = Bitmap.createBitmap(
                original,
                0,
                original.getHeight() / 2,
                original.getWidth(),
                original.getHeight() / 2,
                matrix,
                false
        );

        canvas.drawBitmap(reflection, 0, getHeight(), null);
    }
}