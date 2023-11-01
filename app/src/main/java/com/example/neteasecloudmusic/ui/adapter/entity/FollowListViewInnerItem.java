package com.example.neteasecloudmusic.ui.adapter.entity;

import com.example.neteasecloudmusic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-11-01 16:39
 * @Version 1.0
 */
public class FollowListViewInnerItem {
    static List list = new ArrayList();
    //1.头像
    private int iconOne;
    private String nameOne;
    private String textOne;
    private int imageOne;

    public int getIconOne() {
        return iconOne;
    }

    public void setIconOne(int iconOne) {
        this.iconOne = iconOne;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        this.nameOne = nameOne;
    }

    public String getTextOne() {
        return textOne;
    }

    public void setTextOne(String textOne) {
        this.textOne = textOne;
    }

    public int getImageOne() {
        return imageOne;
    }

    public void setImageOne(int imageOne) {
        this.imageOne = imageOne;
    }

    public static final int[] icon = new int[]{
            R.drawable.tiga,
            R.drawable.dragonarmor,

    };
    public static final String[] name = new String[]{
            "迪迦",
            "炎龙铠甲"

    };
    public static final String[] text = new String[]{
            "大家好我叫迪迦,炎龙铠甲是个傻逼",
            "大家好我叫炎龙铠甲"

    };
    public static final int[] image = new int[]{
            R.drawable.tiga_back,
            R.drawable.dragon_back,
    };

    public static List getData() {
        list.clear();
        for (int i = 0; i < name.length; i++) {
            list.add(new FollowListViewInnerItem(icon[i], name[i], text[i], image[i]));
        }
        return list;
    }

    public FollowListViewInnerItem() {
    }

    public FollowListViewInnerItem(int iconOne, String nameOne, String textOne, int imageOne) {
        this.iconOne = iconOne;
        this.nameOne = nameOne;
        this.textOne = textOne;
        this.imageOne = imageOne;
    }

}
