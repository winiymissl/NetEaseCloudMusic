package com.example.neteasecloudmusic.ui.adapter.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.ListViewInnerItem;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-11-02 17:39
 * @Version 1.0
 */
public class RecyclerViewMineAdapter extends RecyclerView.Adapter{
    List list;

    public RecyclerViewMineAdapter(List list) {
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_mine_inner_listview_item);
            textView1 = itemView.findViewById(R.id.tv_mine_inner_listview_item_1);
            textView2 = itemView.findViewById(R.id.tv_mine_inner_listview_item_2);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_inner_listview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myHolder = (MyViewHolder) holder;
        ListViewInnerItem item = (ListViewInnerItem) list.get(position);
        myHolder.imageView.setImageResource(item.getPicOne());
        myHolder.textView1.setText(item.getNameOne());
        myHolder.textView2.setText(item.getCountOne() + "首");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
