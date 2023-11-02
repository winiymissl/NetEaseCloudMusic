package com.example.neteasecloudmusic.ui.three;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.ListViewInnerItem;
import com.example.neteasecloudmusic.ui.adapter.entity.MineRecyclerView1Item;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.MineRecyclerView1;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.RecyclerViewMineAdapter;
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


    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        imageView = view.findViewById(R.id.iv_mine_fragment);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.rv_mine_1);
        TabLayout tabLayout = view.findViewById(R.id.tab_mine);
//        ViewPager viewPager = view.findViewById(R.id.vp_mine);
//        List list = new ArrayList();
//        HomeFragmentViewPagerAdapter homeFragmentViewPagerAdapter = new HomeFragmentViewPagerAdapter(getChildFragmentManager(), list);
//        viewPager.setAdapter(homeFragmentViewPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);
//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
//            TabLayout.Tab tab = tabLayout.getTabAt(i);
//            if (tab != null) {
//                tab.setText(((MineFragmentInner) list.get(i)).getName());
//            }
//        }
        tabLayout.addTab(tabLayout.newTab().setText("创建歌单"));
        tabLayout.addTab(tabLayout.newTab().setText("收藏歌单"));
        tabLayout.addTab(tabLayout.newTab().setText("歌单助手"));
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                NestedScrollView nestedScrollView = view.findViewById(R.id.nsview_mine);
//                nestedScrollView.smoothScrollTo(0, 1000);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
        MineRecyclerView1 mineRecyclerView1 = new MineRecyclerView1(MineRecyclerView1Item.getData());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mineRecyclerView1);
//        View view = inflater.inflate(R.layout.fragment_mine_inner, container, false);
        RecyclerView listView = view.findViewById(R.id.lv_mine_inner);

        RecyclerViewMineAdapter recyclerViewMineAdapter = new RecyclerViewMineAdapter(ListViewInnerItem.getData());
        listView.setAdapter(recyclerViewMineAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        listView.setLayoutManager(layoutManager);

        RecyclerView listView2 = view.findViewById(R.id.lv_mine_inner_2);
        listView2.setAdapter(recyclerViewMineAdapter);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        listView2.setLayoutManager(layoutManager1);
        RecyclerView listView3 = view.findViewById(R.id.lv_mine_inner_3);
        listView3.setAdapter(recyclerViewMineAdapter);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        listView3.setLayoutManager(layoutManager2);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                // 获取选择的照片的URI
                Uri selectedImageUri = data.getData();

                // 这里可以处理选定的照片，例如显示在ImageView中
                imageView.setImageURI(selectedImageUri);
            }
        }
    }

}
