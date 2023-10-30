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
    public static final int[] pic = new int[]{R.drawable.yuzhibo,

    };
    public static final String[] text = new String[]{"宇智波斑"};


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
