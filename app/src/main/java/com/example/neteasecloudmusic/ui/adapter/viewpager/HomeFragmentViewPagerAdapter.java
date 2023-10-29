package com.example.neteasecloudmusic.ui.adapter.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-26 17:09
 * @Version 1.0
 */
public class HomeFragmentViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public HomeFragmentViewPagerAdapter(@NonNull FragmentManager fm, List list) {
        super(fm);
        this.list = list;
    }

    public HomeFragmentViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
