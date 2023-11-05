package com.example.neteasecloudmusic.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.window.SplashScreen;
import android.window.SplashScreenView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.ActivitySplashBinding;
import com.example.neteasecloudmusic.logic.network.Utils;
import com.example.neteasecloudmusic.test.TestActivity;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.iv.setImageResource(R.drawable.splash);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String cookie = sharedPreferences.getString("cookie", "null");
        Log.d("MyPreferences_cookie", cookie);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (cookie.equals("null")) {
                    Intent intent = new Intent(SplashActivity.this, TestActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);
    }
}