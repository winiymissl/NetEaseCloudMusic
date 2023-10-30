package com.example.neteasecloudmusic.ui.adapter.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neteasecloudmusic.R;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-30 22:32
 * @Version 1.0
 */
public class FollowRecyclerViewAdapter extends RecyclerView.Adapter {
    List list;

    public FollowRecyclerViewAdapter(List list) {
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_follow_recyclerview);
            imageView = itemView.findViewById(R.id.iv_follow_recyclerview_head);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follow_recyclerview_1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewholder = (MyViewHolder) holder;
        list.get(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
