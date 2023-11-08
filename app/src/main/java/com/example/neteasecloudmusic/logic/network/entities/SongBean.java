package com.example.neteasecloudmusic.logic.network.entities;

import java.util.List;

public class SongBean {
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

    public PlayListResult.Al getAl() {
        return al;
    }

    public void setAl(PlayListResult.Al al) {
        this.al = al;
    }

    public List<PlayListResult.Ar> getAr() {
        return ar;
    }

    @Override
    public String toString() {
        return "SongBean{" + "id=" + id + ", name='" + name + '\'' + ", al=" + al + ", ar=" + ar + ", dt=" + dt + '}';
    }

    public void setAr(List<PlayListResult.Ar> ar) {
        this.ar = ar;
    }

    long id;
    String name;
    PlayListResult.Al al;
    List<PlayListResult.Ar> ar;

    int dt;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public class SongUrlBean extends BaseResult {
        List<SongUrl> data;

        @Override
        public String toString() {
            return "SongUrlBean{" + "data=" + data + ", code=" + code + ", message='" + message + '\'' + '}';
        }

        public List<SongUrl> getData() {
            return data;
        }

        public void setData(List<SongUrl> data) {
            this.data = data;
        }
    }

    public class SongUrl {
        @Override
        public String toString() {
            return "SongUrl{" + "url='" + url + '\'' + '}';
        }

        String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
