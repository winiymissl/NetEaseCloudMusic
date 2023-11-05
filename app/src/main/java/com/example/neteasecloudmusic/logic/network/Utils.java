package com.example.neteasecloudmusic.logic.network;

import android.util.Log;

import androidx.lifecycle.ViewModelProvider;

import com.example.neteasecloudmusic.logic.network.apiservice.ApiService;
import com.example.neteasecloudmusic.logic.network.entities.LoginResult;
import com.example.neteasecloudmusic.test.TestActivity;
import com.example.neteasecloudmusic.viewmodel.mine.MineViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
