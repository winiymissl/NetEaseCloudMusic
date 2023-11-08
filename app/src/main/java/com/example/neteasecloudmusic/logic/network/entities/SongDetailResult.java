package com.example.neteasecloudmusic.logic.network.entities;

import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-11-07 13:32
 * @Version 1.0
 */
public class SongDetailResult extends BaseResult {
    List<SongBean> songs;

    public List<SongBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongBean> songs) {
        this.songs = songs;
    }
}






