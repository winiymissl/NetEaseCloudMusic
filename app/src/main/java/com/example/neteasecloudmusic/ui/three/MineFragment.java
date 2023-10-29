package com.example.neteasecloudmusic.ui.three;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.MineRecyclerView1Item;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.MineRecyclerView1;
import com.example.neteasecloudmusic.ui.adapter.viewpager.HomeFragmentViewPagerAdapter;
import com.example.neteasecloudmusic.ui.lookfragment.HomeInnerFragment;
import com.example.neteasecloudmusic.ui.minefragment.MineFragmentInner;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-28 22:40
 * @Version 1.0
 */
public class MineFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_mine_1);
        TabLayout tabLayout = view.findViewById(R.id.tab_mine);
        ViewPager viewPager = view.findViewById(R.id.vp_mine);
        List list = new ArrayList();
        list.add(new MineFragmentInner("创建歌单"));
        HomeFragmentViewPagerAdapter homeFragmentViewPagerAdapter = new HomeFragmentViewPagerAdapter(getActivity().getSupportFragmentManager(), list);
        viewPager.setAdapter(homeFragmentViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setText(((MineFragmentInner) list.get(i)).getName());
            }
        }
        tabLayout.addTab(tabLayout.newTab().setText("收藏歌单"));
        tabLayout.addTab(tabLayout.newTab().setText("歌单助手"));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                NestedScrollView nestedScrollView = view.findViewById(R.id.nsview_mine);
//                nestedScrollView.smoothScrollTo(0, 1000);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        MineRecyclerView1 mineRecyclerView1 = new MineRecyclerView1(MineRecyclerView1Item.getData());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mineRecyclerView1);
        return view;
    }
}
