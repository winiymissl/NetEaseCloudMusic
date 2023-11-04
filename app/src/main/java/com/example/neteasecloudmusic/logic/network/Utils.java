package com.example.neteasecloudmusic.logic.network;

import com.example.neteasecloudmusic.logic.network.apiservice.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author winiymissl
 * @Date 2023-11-04 21:36
 * @Version 1.0
 */
public class Utils {
    public static final Retrofit RETROFIT = new Retrofit.Builder().baseUrl("http://192.168.0.104:3000/").addConverterFactory(GsonConverterFactory.create()).build();
    public static final ApiService SERVICE = Utils.RETROFIT.create(ApiService.class);
}
