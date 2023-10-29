package com.example.neteasecloudmusic.ui.adapter.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.adapter.entity.RecyclerViewItemPic;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-28 21:56
 * @Version 1.0
 */
public class HomeInnerRecyclerViewPicAdapter extends RecyclerView.Adapter {

    List list;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageButton imageButton;
        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_inner_recommend_fragment_pic);
            imageButton = itemView.findViewById(R.id.ib_inner_recommend_fragment_pic);
        }
    }

    public HomeInnerRecyclerViewPicAdapter(List list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inner_fragment_recommend_recyclerview_pic, parent, false);
        return new HomeInnerRecyclerViewPicAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        RecyclerViewItemPic recyclerViewItem = (RecyclerViewItemPic) list.get(position);
        myViewHolder.imageButton.setImageResource(recyclerViewItem.getPicOne());
        myViewHolder.textView.setText(recyclerViewItem.getTextOne());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
