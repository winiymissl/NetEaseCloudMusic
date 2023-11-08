package com.example.neteasecloudmusic.logic.network.entities;

import java.io.Serializable;
import java.util.List;

/**
 * @Author winiymissl
 * @Date 2023-11-05 17:46
 * @Version 1.0
 */
public class PlayListResult {
    public class UserPlayListResult extends BaseResult {
        List<PlaylistBean> playlist;

        public List<PlaylistBean> getPlaylist() {
            return playlist;
        }

        @Override
        public String toString() {
            return "UserPlayListResult{" + "playlist=" + playlist + '}';
        }

        public void setPlaylist(List<PlaylistBean> playlist) {
            this.playlist = playlist;
        }
    }

    public class PlaylistBean {
        List<Track> tracks;
        List<TrackId> trackIds;
        Subscribers creator;
        String name;
        String coverImgUrl;
        int trackCount;
        long id;
        long playCount;
        String description;
        int shareCount;
        int commentCount;

        @Override
        public String toString() {
            return "PlaylistBean{" + "tracks=" + tracks + ", trackIds=" + trackIds + ", creator=" + creator + ", name='" + name + '\'' + ", coverImgUrl='" + coverImgUrl + '\'' + ", trackCount=" + trackCount + ", id=" + id + ", playCount=" + playCount + ", description='" + description + '\'' + ", shareCount=" + shareCount + ", commentCount=" + commentCount + '}';
        }

        public List<Track> getTracks() {
            return tracks;
        }

        public void setTracks(List<Track> tracks) {
            this.tracks = tracks;
        }

        public List<TrackId> getTrackIds() {
            return trackIds;
        }

        public void setTrackIds(List<TrackId> trackIds) {
            this.trackIds = trackIds;
        }

        public Subscribers getCreator() {
            return creator;
        }

        public void setCreator(Subscribers creator) {
            this.creator = creator;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getPlayCount() {
            return playCount;
        }

        public void setPlayCount(long playCount) {
            this.playCount = playCount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }


    }

    public class Subscribers implements Serializable {
        @Override
        public String toString() {
            return "Subscribers{" + "id=" + id + ", avatarUrl='" + avatarUrl + '\'' + ", nickname='" + nickname + '\'' + '}';
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        long id;
        String avatarUrl;
        String nickname;
    }


    public class Track implements Serializable {
        @Override
        public String toString() {
            return "Track{" + "name='" + name + '\'' + ", id=" + id + ", mv=" + mv + ", ar=" + ar + ", al=" + al + '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getMv() {
            return mv;
        }

        public void setMv(long mv) {
            this.mv = mv;
        }

        public List<Ar> getAr() {
            return ar;
        }

        public void setAr(List<Ar> ar) {
            this.ar = ar;
        }

        public Al getAl() {
            return al;
        }

        public void setAl(Al al) {
            this.al = al;
        }

        String name; //歌曲的名字
        long id; //歌曲的id
        long mv;
        List<Ar> ar; //作者：可能会有多个
        Al al; //专辑

    }

    public class Ar {
        @Override
        public String toString() {
            return name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        long id;
        String name;
    }

    public class Al {
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        @Override
        public String toString() {
            return "Al{" + "id=" + id + ", name='" + name + '\'' + ", picUrl='" + picUrl + '\'' + '}';
        }

        long id;
        String name;
        String picUrl;
    }

    public class TrackId implements Serializable {
        @Override
        public String toString() {
            return "TrackId{" + "id=" + id + ", v=" + v + ", alg='" + alg + '\'' + '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        int id;
        int v;
        String alg;
    }
}
