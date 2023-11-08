package com.example.neteasecloudmusic.logic.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author winiymissl
 */
public class MyService extends Service {
    //创建底部音乐播放栏,
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}