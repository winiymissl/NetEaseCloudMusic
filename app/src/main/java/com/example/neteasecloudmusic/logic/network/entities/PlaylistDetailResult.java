package com.example.neteasecloudmusic.logic.network.entities;

/**
 * @Author winiymissl
 * @Date 2023-11-05 21:49
 * @Version 1.0
 */
public class PlaylistDetailResult extends BaseResult {
    PlayListResult.PlaylistBean playlist;

    public PlayListResult.PlaylistBean getPlaylist() {
        return playlist;
    }

    @Override
    public String toString() {
        return "PlaylistDetailResult{" +
                "playlist=" + playlist +
                '}';
    }

    public void setPlaylist(PlayListResult.PlaylistBean playlist) {
        this.playlist = playlist;
    }
}
