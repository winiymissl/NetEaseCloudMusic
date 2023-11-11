package com.example.neteasecloudmusic.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.ActivityTest2Binding;

/**
 * @author winiymissls
 */
public class Test2Activity extends AppCompatActivity {
    ActivityTest2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTest2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //view动画
//                Animation animation = AnimationUtils.loadAnimation(Test2Activity.this, R.anim.slide_down);
//                binding.test2.startAnimation(animation);
                //属性动画
                ObjectAnimator.ofFloat(binding.test2, "rotationY", 0f, 360f).setDuration(4000).start();
                Animator animator = AnimatorInflater.loadAnimator(Test2Activity.this, R.animator.rotate);
                animator.setTarget(binding.test2);
                animator.start();
                AnimationSet animationSet = new AnimationSet(true);
                Intent intent = new Intent(Test2Activity.this, MyIntentService.class);
                Log.d("IntentServiceTest", Thread.currentThread().getName());
                startService(intent);
            }
        });
    }
}