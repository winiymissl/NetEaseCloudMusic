package com.example.neteasecloudmusic.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.logic.network.Utils;
import com.example.neteasecloudmusic.logic.network.entities.LoginResult;
import com.example.neteasecloudmusic.ui.three.FollowFragment;
import com.example.neteasecloudmusic.ui.three.LookFragment;
import com.example.neteasecloudmusic.ui.adapter.viewpager.HomeFragmentViewPagerAdapter;
import com.example.neteasecloudmusic.ui.three.MineFragment;
import com.example.neteasecloudmusic.viewmodel.mine.MineViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author winiymissl
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {
    private ImageButton imageButton_listen_song;
    private ImageButton imageButton_scan;
    private TextView textView_search;
    private HomeFragmentViewPagerAdapter homeFragmentViewPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = findViewById(R.id.vp_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav_home_activity);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        List<Fragment> list = new ArrayList();
        list.add(new LookFragment());
        list.add(new MineFragment());
        list.add(new FollowFragment());
        homeFragmentViewPagerAdapter = new HomeFragmentViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(homeFragmentViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    bottomNavigationView.setSelectedItemId(R.id.navigation_look);
                }
                if (position == 1) {
                    bottomNavigationView.setSelectedItemId(R.id.navigation_mine);
                }
                if (position == 2) {
                    bottomNavigationView.setSelectedItemId(R.id.navigation_follow);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.navigation_look) {
            viewPager.setCurrentItem(0, true);
        }
        if (item.getItemId() == R.id.navigation_mine) {
            viewPager.setCurrentItem(1, true);
        }
        if (item.getItemId() == R.id.navigation_follow) {
            viewPager.setCurrentItem(2, true);
        }
        return true;
    }
}