package com.example.neteasecloudmusic.ui.followfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.FollowListViewInnerItem;
import com.example.neteasecloudmusic.ui.adapter.listview.FollowInnerListViewAdapter;

/**
 * @Author winiymissl
 * @Date 2023-11-01 11:40
 * @Version 1.0
 */
public class FollowInnerFragment extends Fragment {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FollowInnerFragment() {

    }

    public FollowInnerFragment(String name) {
        this.name = name;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow_inner, container, false);
        ListView listView = view.findViewById(R.id.lv_follow_inner);
        FollowInnerListViewAdapter followInnerListViewAdapter = new FollowInnerListViewAdapter(FollowListViewInnerItem.getData());
        listView.setAdapter(followInnerListViewAdapter);
        return view;
    }
}
