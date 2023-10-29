package com.example.neteasecloudmusic.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.neteasecloudmusic.R;

/**
 * @author winiymissl
 */
public class ListenSongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_song);
        Toolbar toolbar = findViewById(R.id.tb_listen_song_activity);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = getWindow().getDecorView();
            // 关闭 windowLightStatusBar 属性
            decor.setSystemUiVisibility(0);
        }
        ImageButton imageButton = findViewById(R.id.ib_top_listen);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}