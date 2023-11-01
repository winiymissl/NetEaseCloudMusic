package com.example.neteasecloudmusic.ui.adapter.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.FollowListViewInnerItem;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-11-01 11:54
 * @Version 1.0
 */
public class FollowInnerListViewAdapter extends BaseAdapter {
    List list;

    public FollowInnerListViewAdapter(List list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follow_recyclerview_2, parent, false);
        } else {
            view = convertView;
        }
        FollowListViewInnerItem followListViewInnerItem = (FollowListViewInnerItem) list.get(position);
        TextView name = view.findViewById(R.id.tv_follow_recyclerview_2_name);
        TextView text = view.findViewById(R.id.tv_follow_recyclerview_2_text);
        ImageView icon = view.findViewById(R.id.iv_follow_recyclerview_2_icon);
        ImageView image = view.findViewById(R.id.iv_follow_recyclerview_2_image);
        name.setText(followListViewInnerItem.getNameOne());
        text.setText(followListViewInnerItem.getTextOne());
        icon.setImageResource(followListViewInnerItem.getIconOne());
        image.setImageResource(followListViewInnerItem.getImageOne());
        return view;
    }
}
