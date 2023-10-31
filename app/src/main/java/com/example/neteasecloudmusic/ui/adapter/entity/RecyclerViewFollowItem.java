package com.example.neteasecloudmusic.ui.adapter.entity;

import com.example.neteasecloudmusic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-30 22:38
 * @Version 1.0
 */
public class RecyclerViewFollowItem {
    int picOne;
    String nameOne;
    static List list = new ArrayList();
    public static final int[] pic = new int[]{
            R.drawable.yuzhibo,
            R.drawable.mingren,
            R.drawable.you,
            R.drawable.zuozhu,
            R.drawable.kakaxi,
            R.drawable.prime,
            R.drawable.spiderman,
    };
    public static final String[] text = new String[]{
            "宇智波斑",
            "漩涡鸣人",
            "宇智波鼬",
            "宇智波佐助",
            "旗木卡卡西",
            "擎天柱",
            "彼得帕克",
    };

    public int getPicOne() {
        return picOne;
    }

    public void setPicOne(int picOne) {
        this.picOne = picOne;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        this.nameOne = nameOne;
    }

    public RecyclerViewFollowItem(int picOne, String nameOne) {
        this.nameOne = nameOne;
        this.picOne = picOne;
    }

    public static List getData() {
        list.clear();
        for (int i = 0; i < text.length; i++) {
            list.add(new RecyclerViewFollowItem(pic[i], text[i]));
        }
        return list;
    }
}
