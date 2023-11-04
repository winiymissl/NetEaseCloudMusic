package com.example.neteasecloudmusic.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.window.SplashScreen;
import android.window.SplashScreenView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.ActivitySplashBinding;
import com.example.neteasecloudmusic.test.TestActivity;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.iv.setImageResource(R.drawable.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, TestActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}