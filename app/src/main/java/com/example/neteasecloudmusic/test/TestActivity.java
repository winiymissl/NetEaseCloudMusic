package com.example.neteasecloudmusic.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.ActivityTestBinding;
import com.example.neteasecloudmusic.ui.minefragment.MineInnerFragment;

import retrofit2.http.Tag;

/**
 * @author winiymissl
 */
public class TestActivity extends AppCompatActivity {
    ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.bind(LayoutInflater.from(this).inflate(R.layout.activity_test, null, false));
        setContentView(binding.getRoot());
    }
}