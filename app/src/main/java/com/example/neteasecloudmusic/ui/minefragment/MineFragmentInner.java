package com.example.neteasecloudmusic.ui.minefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.ListViewInnerItem;
import com.example.neteasecloudmusic.ui.adapter.listview.ListViewInnerAdapter;
import com.example.neteasecloudmusic.ui.three.MineFragment;

/**
 * @Author winiymissl
 * @Date 2023-10-29 13:36
 * @Version 1.0
 */
public class MineFragmentInner extends Fragment {
    private String name;

    public MineFragmentInner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_inner, container, false);
        ListView listView = view.findViewById(R.id.lv_mine_inner);
        ListViewInnerAdapter listViewInnerAdapter = new ListViewInnerAdapter(getActivity(), ListViewInnerItem.getData());
        listView.setAdapter(listViewInnerAdapter);

        ListView listView2 = view.findViewById(R.id.lv_mine_inner_2);
        listView2.setAdapter(listViewInnerAdapter);
        ListView listView3 = view.findViewById(R.id.lv_mine_inner_3);
        listView3.setAdapter(listViewInnerAdapter);
        return view;
    }
}
