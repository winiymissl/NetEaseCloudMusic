package com.example.neteasecloudmusic.ui.adapter.entity;

import com.example.neteasecloudmusic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-27 12:17
 * @Version 1.0
 */
public class RecyclerViewItem {
    public static List<RecyclerViewItem> list = new ArrayList<>();
    private static final int[] image = new int[]{
            R.drawable.remmend,
            R.drawable.radio,
            R.drawable.songsheet,
            R.drawable.ranking,
            R.drawable.ablum,
            R.drawable.book,
            R.drawable.user_music,
            R.drawable.onesong,
            R.drawable.hammar,
            R.drawable.songhouse,
            R.drawable.game};
    private static final String[] text = new String[]{"每日推荐", "私人漫游", "歌单", "排行榜", "数字专辑", "有声书", "关注新歌", "一歌一遇", "收藏家", "歌房", "游戏专区",};
    private int imageOne;

    public int getImageOne() {
        return imageOne;
    }

    public void setImageOne(int imageOne) {
        this.imageOne = imageOne;
    }

    public String getTextOne() {
        return textOne;
    }

    public void setTextOne(String textOne) {
        this.textOne = textOne;
    }

    private String textOne;

    public RecyclerViewItem(int imageOne, String textOne) {
        this.imageOne = imageOne;
        this.textOne = textOne;
    }

    public static List<RecyclerViewItem> getData() {
        list.clear();
        for (int i = 0; i < text.length; i++) {
            list.add(new RecyclerViewItem(image[i], text[i]));
        }
        return list;
    }
}
