package com.example.neteasecloudmusic.ui.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.logic.network.entities.PlayListResult;
import com.example.neteasecloudmusic.ui.adapter.entity.ListViewInnerItem;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-11-02 17:39
 * @Version 1.0
 */
public class RecyclerViewMineAdapter extends RecyclerView.Adapter {
    List list;
    Context context;

    public RecyclerViewMineAdapter(Context context, List list) {
        this.context = context;
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
        PlayListResult.PlaylistBean item = (PlayListResult.PlaylistBean) list.get(position);
        Glide.with(context) // 使用Glide加载图片
                .load(item.getCoverImgUrl()) // 加载网络图片的URL
                .error(R.drawable.yuzhibo) // 设置加载失败时显示的图片
                .into(myHolder.imageView); // 将图片设置到ImageView
        myHolder.textView1.setText(item.getName());
        myHolder.textView2.setText(String.valueOf(item.getTrackCount()) + "首");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
