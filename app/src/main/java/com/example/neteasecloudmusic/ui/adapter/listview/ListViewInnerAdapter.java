package com.example.neteasecloudmusic.ui.adapter.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.ListViewInnerItem;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-29 15:23
 * @Version 1.0
 */
public class ListViewInnerAdapter extends BaseAdapter {
    List list;
    Context context;

    public ListViewInnerAdapter(Context context, List list) {
        this.list = list;
        this.context = context;
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
            view = LayoutInflater.from(context).inflate(R.layout.item_mine_inner_listview, parent, false);
        } else {
            view = convertView;
        }
        ImageView imageView = view.findViewById(R.id.iv_mine_inner_listview_item);
        TextView textView1 = view.findViewById(R.id.tv_mine_inner_listview_item_1);
        TextView textView2 = view.findViewById(R.id.tv_mine_inner_listview_item_2);
        ListViewInnerItem item = (ListViewInnerItem) list.get(position);
        imageView.setImageResource(item.getPicOne());
        textView1.setText(item.getNameOne());
        textView2.setText(item.getCountOne() + "首");
        return view;
    }
}
