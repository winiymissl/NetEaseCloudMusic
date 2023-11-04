package com.example.neteasecloudmusic.logic.network.apiservice;

import android.util.Log;

import androidx.work.Data;

import com.example.neteasecloudmusic.logic.network.entities.LoginResult;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Author winiymissl
 * @Date 2023-11-04 14:31
 * @Version 1.0
 */
public interface ApiService {
    /**
     * @param time 时间戳，防止缓存
     * @return 返回qr码的key
     */
    @GET("/login/qr/key")
    Call<LoginResult.QrcodeKeyResult> getLoginQrcodeKey(@Query("timeStamp") String time);

    @GET("/login/qr/create")
    Call<LoginResult.QrcodeValueResult> getLoginQrcodeValue(@Query("key") String key, @Query("timeStamp") String time);

    @GET("/login/qr/check")
    Call<LoginResult.QrcodeAuthResult> checkQrcodeAuthStatus(@Query("key") String key, @Query("timeStamp") String time);
}
