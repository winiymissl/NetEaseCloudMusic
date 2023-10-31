package com.example.neteasecloudmusic.ui.three;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.RecyclerViewFollowItem;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.FollowRecyclerViewAdapter;

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


        return view;
    }
}
