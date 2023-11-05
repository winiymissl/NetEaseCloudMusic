package com.example.neteasecloudmusic.ui.adapter.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neteasecloudmusic.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-11-05 22:47
 * @Version 1.0
 */
public class SongListRecyclerViewAdapter extends RecyclerView.Adapter {
    List list;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_authority_name;
        TextView textView_song_name;
        TextView textView_num;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_num = itemView.findViewById(R.id.tv_num_song_list);
            textView_song_name = itemView.findViewById(R.id.song_name);
            textView_authority_name = itemView.findViewById(R.id.authority_name);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        list.get(position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
