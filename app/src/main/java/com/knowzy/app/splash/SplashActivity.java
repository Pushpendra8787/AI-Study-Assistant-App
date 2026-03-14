package com.knowzy.app.splash;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.knowzy.app.MainActivity;
import com.knowzy.app.R;

import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView name;
    private TextView tagline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.logoImage);
        name = findViewById(R.id.appName);
        tagline = findViewById(R.id.tagline);

        startAnimations();

        new Handler().postDelayed(() -> {

            startActivity(new Intent(this, MainActivity.class));
            finish();

        }, 3500);
    }

    private void startAnimations() {

        // Logo fade in
        ObjectAnimator logoFade = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);
        logoFade.setDuration(1000);

        // Logo scale effect
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0.8f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0.8f, 1f);

        scaleX.setDuration(1000);
        scaleY.setDuration(1000);

        // Glow pulse on logo
        ObjectAnimator pulse = ObjectAnimator.ofFloat(logo, "alpha", 0.8f, 1f);
        pulse.setDuration(800);
        pulse.setRepeatCount(ValueAnimator.INFINITE);
        pulse.setRepeatMode(ValueAnimator.REVERSE);

        // Text animations
        ObjectAnimator textFade = ObjectAnimator.ofFloat(name, "alpha", 0f, 1f);
        textFade.setDuration(1500);

        ObjectAnimator taglineFade = ObjectAnimator.ofFloat(tagline, "alpha", 0f, 1f);
        taglineFade.setDuration(1800);

        logoFade.start();
        scaleX.start();
        scaleY.start();
        pulse.start();
        textFade.start();
        taglineFade.start();
    }
}