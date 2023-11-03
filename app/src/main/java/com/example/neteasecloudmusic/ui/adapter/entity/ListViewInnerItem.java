package com.example.neteasecloudmusic.ui.adapter.entity;

import com.example.neteasecloudmusic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-29 15:48
 * @Version 1.0
 */
public class ListViewInnerItem {
    private int picOne;
    private String countOne;
    private String nameOne;
    static List list = new ArrayList();

    public static final int[] pic = new int[]{
            R.drawable.yuzhibo,
            R.drawable.yuzhibo,
            R.drawable.yuzhibo,
            R.drawable.yuzhibo,
            R.drawable.yuzhibo,

    };
    public static final String[] name = new String[]{
            "宇智波斑",
            "宇智波斑",
            "宇智波斑",
            "宇智波斑",
            "宇智波斑",
    };
    public static final String[] count = new String[]{
            "5",
            "5",
            "5",
            "5",
            "5",
    };

    public static List getData() {
        list.clear();
        for (int i = 0; i < pic.length; i++) {
            list.add(new ListViewInnerItem(pic[i], name[i], count[i]));
        }
        return list;
    }

    public ListViewInnerItem(int picOne, String nameOne, String countOne) {
        this.picOne = picOne;
        this.nameOne = nameOne;
        this.countOne = countOne;
    }

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

    public String getCountOne() {
        return countOne;
    }

    public void setCountOne(String countOne) {
        this.countOne = countOne;
    }
}


