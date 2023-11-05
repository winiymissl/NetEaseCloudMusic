package com.example.neteasecloudmusic.ui.three;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.FragmentMineBinding;
import com.example.neteasecloudmusic.logic.network.entities.LoginResult;
import com.example.neteasecloudmusic.logic.network.entities.PlayListResult;
import com.example.neteasecloudmusic.ui.adapter.entity.MineRecyclerView1Item;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.MineRecyclerView1;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.RecyclerViewMineAdapter;
import com.example.neteasecloudmusic.viewmodel.mine.MineViewModel;
import com.google.android.material.tabs.TabLayout;

/**
 * @Author winiymissl
 * @Date 2023-10-28 22:40
 * @Version 1.0
 */
public class MineFragment extends Fragment {
    private ImageView imageView;
    FragmentMineBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        binding = FragmentMineBinding.bind(view);
        MineViewModel model = new ViewModelProvider(getActivity()).get(MineViewModel.class);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        model.getAccountInfo(sharedPreferences.getString("cookie", "null"));
        model.getUserData().observe(getViewLifecycleOwner(), new Observer<LoginResult.AccountInfoResult>() {
            @Override
            public void onChanged(LoginResult.AccountInfoResult accountInfoResult) {
                LoginResult.AccountInfoResult value = accountInfoResult;
                Log.d("CheckWhetherGotIt", value.getProfile().toString() + "\n" + value.getAccount().toString());
                //nickname
                binding.tvMineCardview.setText(value.getProfile().getNickname());
                //头像
                Glide.with(getActivity()) // 使用Glide加载图片
                        .load(value.getProfile().getAvatarUrl()) // 加载网络图片的URL
                        .error(R.drawable.yuzhibo) // 设置加载失败时显示的图片
                        .into(imageView); // 将图片设置到ImageView
                //得到喜欢的歌单的信息
                model.getPlaylist().observe(getViewLifecycleOwner(), new Observer<PlayListResult.UserPlayListResult>() {
                    @Override
                    public void onChanged(PlayListResult.UserPlayListResult userPlayListResult) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.tvMineLove.setText(userPlayListResult.getPlaylist().get(0).getName());
                                binding.tvMineLoveCount.setText(String.valueOf(userPlayListResult.getPlaylist().get(0).getTrackCount()) + "首");
                                Glide.with(getActivity()) // 使用Glide加载图片
                                        .load(userPlayListResult.getPlaylist().get(0).getCoverImgUrl()) // 加载网络图片的URL
                                        .error(R.drawable.yuzhibo) // 设置加载失败时显示的图片
                                        .into(binding.ivMineLove); // 将图片设置到ImageView
                                RecyclerView listView = view.findViewById(R.id.lv_mine_inner);
                                RecyclerViewMineAdapter recyclerViewMineAdapter = new RecyclerViewMineAdapter(getActivity(), userPlayListResult.getPlaylist());
                                listView.setAdapter(recyclerViewMineAdapter);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                listView.setLayoutManager(layoutManager);
                                model.getPlaylistDetail(userPlayListResult.getPlaylist().get(0).getId());
                            }
                        });
                    }
                });
                model.getPlayListInfo(value.getProfile().getUserId());
                Log.d("setLayoutManager", String.valueOf(value.getProfile().getUserId()));
            }
        });


        DrawerLayout drawerLayout = getActivity().findViewById(R.id.drawerLayout_home);
        ImageButton imageButton = view.findViewById(R.id.ib_mine);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
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

        tabLayout.addTab(tabLayout.newTab().setText("创建歌单"));
        tabLayout.addTab(tabLayout.newTab().setText("收藏歌单"));
        tabLayout.addTab(tabLayout.newTab().setText("歌单助手"));

        MineRecyclerView1 mineRecyclerView1 = new MineRecyclerView1(MineRecyclerView1Item.getData());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mineRecyclerView1);


//        RecyclerView listView2 = view.findViewById(R.id.lv_mine_inner_2);
//        listView2.setAdapter(recyclerViewMineAdapter);
//        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
//        listView2.setLayoutManager(layoutManager1);
//        RecyclerView listView3 = view.findViewById(R.id.lv_mine_inner_3_);
//        listView3.setAdapter(recyclerViewMineAdapter);
//        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext());
//        listView3.setLayoutManager(layoutManager2);
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
