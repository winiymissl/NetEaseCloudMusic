package com.example.neteasecloudmusic.ui.adapter.recyclerview;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.MineRecyclerView1Item;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-29 12:15
 * @Version 1.0
 */
public class MineRecyclerView1 extends RecyclerView.Adapter {
    List list;

    public MineRecyclerView1(List list) {
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageButton imageButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.ib_mine_recyclerview_1);
            textView = itemView.findViewById(R.id.tv_mine_recyclerview_1);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_recyclerview_1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myHolder = (MyViewHolder) holder;
        MineRecyclerView1Item item = (MineRecyclerView1Item) list.get(position);
        myHolder.textView.setText(item.getTextOne());
        myHolder.imageButton.setImageResource(item.getPicOne());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
