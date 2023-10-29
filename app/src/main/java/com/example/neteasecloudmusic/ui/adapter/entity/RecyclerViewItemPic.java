package com.example.neteasecloudmusic.ui.adapter.entity;

import com.example.neteasecloudmusic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-28 21:49
 * @Version 1.0
 */
public class RecyclerViewItemPic {
    static List list = new ArrayList();
    private int picOne;
    private String textOne;
    public static final String[] text = new String[]{
            "现实美学",
            "luffy",
            "boat",
            "naruto",
            "detective"
    };
    public static final int[] pic = new int[]{
            R.drawable.beauty,
            R.drawable.luffy,
            R.drawable.boat,
            R.drawable.naruto,
            R.drawable.detective,
    };

    public RecyclerViewItemPic(int picOne, String textOne) {
        this.picOne = picOne;
        this.textOne = textOne;
    }

    public int getPicOne() {
        return picOne;
    }

    public void setPicOne(int picOne) {
        this.picOne = picOne;
    }

    public String getTextOne() {
        return textOne;
    }

    public void setTextOne(String textOne) {
        this.textOne = textOne;
    }

    public static List getData() {
        list.clear();
        for (int i = 0; i < text.length; i++) {
            list.add(new RecyclerViewItemPic(pic[i], text[i]));
        }
        return list;
    }
}
