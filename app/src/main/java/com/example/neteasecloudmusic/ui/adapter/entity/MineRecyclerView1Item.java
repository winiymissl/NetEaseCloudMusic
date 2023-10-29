package com.example.neteasecloudmusic.ui.adapter.entity;

import com.example.neteasecloudmusic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-10-29 11:44
 * @Version 1.0
 */
public class MineRecyclerView1Item {
    static List list = new ArrayList();
    private int picOne;
    private String textOne;
    public static final String[] text = new String[]{
            "本地下载",
            "云盘",
            "已购",
            "最近播放",
            "我的好友",
            "收藏和赞",
            "说唱专区",
            "最嗨电音",
            "火前留名",
            "云推歌曲",
            "交友",
            "音乐应用"
    };
    public static final int[] pic = new int[]{
            R.drawable.music_download,
            R.drawable.cloud_music,
            R.drawable.bought,
            R.drawable.play_radio,
            R.drawable.myfriend,
            R.drawable.collect,
            R.drawable.rapper,
            R.drawable.agora,
            R.drawable.fire,
            R.drawable.remmendsong,
            R.drawable.makefriend,
            R.drawable.addmore,
    };

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


    public MineRecyclerView1Item(int picOne, String textOne) {
        this.picOne = picOne;
        this.textOne = textOne;
    }

    public static List getData() {
        list.clear();
        for (int i = 0; i < text.length; i++) {
            list.add(new MineRecyclerView1Item(pic[i], text[i]));
        }
        return list;
    }
}
