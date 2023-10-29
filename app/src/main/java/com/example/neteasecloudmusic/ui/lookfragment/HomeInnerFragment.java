package com.example.neteasecloudmusic.ui.lookfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.HomeInnerRecyclerViewAdapter;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.HomeInnerRecyclerViewPicAdapter;
import com.example.neteasecloudmusic.ui.adapter.entity.RecyclerViewItem;
import com.example.neteasecloudmusic.ui.adapter.entity.RecyclerViewItemPic;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author winiymissl
 */
public class HomeInnerFragment extends Fragment {
    private String name;

    public HomeInnerFragment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Banner banner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_innner, container, false);
        banner = view.findViewById(R.id.banner_inner_fragment);
        List list_banner_ad = new ArrayList();
        list_banner_ad.add(R.drawable.orange);
        list_banner_ad.add(R.drawable.peaches);
        list_banner_ad.add(R.drawable.pear);
        list_banner_ad.add(R.drawable.strawberry);
        banner.setAdapter(new BannerImageAdapter(list_banner_ad) {
            @Override
            public void onBindView(Object holder, Object data, int position, int size) {
                BannerImageHolder imageHolder = (BannerImageHolder) holder;
                imageHolder.imageView.setImageResource((Integer) data);
            }
        });
        banner.isAutoLoop(true);
        banner.setIndicator(new CircleIndicator(getActivity()));
        banner.setIndicatorSelectedColor(getResources().getColor(R.color.white));
        RecyclerView recyclerView = view.findViewById(R.id.rv_inner_fragment_recommend);
        HomeInnerRecyclerViewAdapter homeInnerRecyclerViewAdapter = new HomeInnerRecyclerViewAdapter(RecyclerViewItem.getData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeInnerRecyclerViewAdapter);

        try {
            RecyclerView recyclerView_pic = view.findViewById(R.id.rv_inner_fragment_recommend_pic);
            LinearLayoutManager linearLayoutManager_pic = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView_pic.setLayoutManager(linearLayoutManager_pic);
            HomeInnerRecyclerViewPicAdapter homeInnerRecyclerViewAdapter_pic = new HomeInnerRecyclerViewPicAdapter(RecyclerViewItemPic.getData());
            recyclerView_pic.setAdapter(homeInnerRecyclerViewAdapter_pic);
        } catch (Exception e) {
            Log.d("asdfhlajksdhfkljahsdf", e.toString());
        }
        TextView textView = view.findViewById(R.id.tv_inner_recommend_fragment_test);
        textView.setText(new String("世界你好").repeat(300));
        return view;
    }
}