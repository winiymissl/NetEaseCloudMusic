package com.example.neteasecloudmusic.ui.three;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.RecyclerViewFollowItem;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.FollowRecyclerViewAdapter;
import com.example.neteasecloudmusic.ui.adapter.viewpager.HomeFragmentViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-29 21:33
 * @Version 1.0
 */
public class FollowFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        RecyclerView recyclerView_1 = view.findViewById(R.id.rv_follow_1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        FollowRecyclerViewAdapter followRecyclerViewAdapter = new FollowRecyclerViewAdapter(RecyclerViewFollowItem.getData());
        recyclerView_1.setAdapter(followRecyclerViewAdapter);
        recyclerView_1.setLayoutManager(layoutManager);

        TabLayout tabLayout = view.findViewById(R.id.tab_follow_now);
        tabLayout.addTab(tabLayout.newTab().setText("全部"));
        tabLayout.addTab(tabLayout.newTab().setText("音乐人"));
        tabLayout.addTab(tabLayout.newTab().setText("朋友"));
        //放置碎片
        List list = new ArrayList();
//        HomeFragmentViewPagerAdapter homeFragmentViewPagerAdapter = new HomeFragmentViewPagerAdapter();
        ViewPager viewPager = view.findViewById(R.id.vp_follow);

        return view;
    }
}
