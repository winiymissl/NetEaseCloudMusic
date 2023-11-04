package com.example.neteasecloudmusic.ui.three;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.RecyclerViewFollowItem;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.FollowRecyclerViewAdapter;
import com.example.neteasecloudmusic.ui.adapter.viewpager.HomeFragmentViewPagerAdapter;
import com.example.neteasecloudmusic.ui.followfragment.FollowInnerFragment;
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
        DrawerLayout drawerLayout = getActivity().findViewById(R.id.drawerLayout_home);
        ImageButton imageButton = view.findViewById(R.id.ib_follow_drawer);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    drawerLayout.openDrawer(GravityCompat.START);
                } catch (Exception e) {
                    Log.d("ImageButtonWhetherHaveQuestion", e.toString());
                }
            }
        });


        RecyclerView recyclerView_1 = view.findViewById(R.id.rv_follow_1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        FollowRecyclerViewAdapter followRecyclerViewAdapter = new FollowRecyclerViewAdapter(RecyclerViewFollowItem.getData());
        recyclerView_1.setAdapter(followRecyclerViewAdapter);
        recyclerView_1.setLayoutManager(layoutManager);

        TabLayout tabLayout = view.findViewById(R.id.tab_follow_now);
        //放置碎片
        List list = new ArrayList();
        list.add(new FollowInnerFragment("全部"));
        list.add(new FollowInnerFragment("音乐人"));
        list.add(new FollowInnerFragment("朋友"));
        HomeFragmentViewPagerAdapter homeFragmentViewPagerAdapter = new HomeFragmentViewPagerAdapter(getChildFragmentManager(), list);
        ViewPager viewPager = view.findViewById(R.id.vp_follow);
        viewPager.setAdapter(homeFragmentViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i);
            tabAt.setText(((FollowInnerFragment) list.get(i)).getName());
        }
        return view;
    }
}
