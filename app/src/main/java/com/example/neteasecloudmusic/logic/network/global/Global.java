package com.example.neteasecloudmusic.logic.network.global;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.session.MediaController;

/**
 * @Author winiymissl
 * @Date 2023-11-05 14:03
 * @Version 1.0
 */
public class Global extends Application {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    static MediaPlayer mediaPlayer;

    public static MediaPlayer getMediaPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            return mediaPlayer;
        }
        return mediaPlayer;
    }

    public static Context getAppContext() {
        return appContext;
    }
}
