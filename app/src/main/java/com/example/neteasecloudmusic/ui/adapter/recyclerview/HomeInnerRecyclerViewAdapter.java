package com.example.neteasecloudmusic.ui.adapter.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.RecyclerViewItem;

import java.util.List;

import kotlin.jvm.Throws;

/**
 * @Author winiymissl
 * @Date 2023-10-27 12:05
 * @Version 1.0
 */
public class HomeInnerRecyclerViewAdapter extends RecyclerView.Adapter {
    List list;
    private int which;

    class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageButton imageButton;
        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_inner_recommend_fragment);
            imageButton = itemView.findViewById(R.id.ib_inner_recommend_fragment);
        }
    }


    public HomeInnerRecyclerViewAdapter(List list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inner_fragment_recommend_recyclerview, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        RecyclerViewItem recyclerViewItem = (RecyclerViewItem) list.get(position);
        myViewHolder.imageButton.setImageResource(recyclerViewItem.getImageOne());
        myViewHolder.textView.setText(recyclerViewItem.getTextOne());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
