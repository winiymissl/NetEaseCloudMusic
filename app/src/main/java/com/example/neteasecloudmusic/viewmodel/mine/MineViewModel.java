package com.example.neteasecloudmusic.viewmodel.mine;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.neteasecloudmusic.logic.network.Utils;
import com.example.neteasecloudmusic.logic.network.entities.LoginResult;
import com.example.neteasecloudmusic.logic.network.entities.PlayListResult;
import com.example.neteasecloudmusic.logic.network.entities.PlaylistDetailResult;
import com.example.neteasecloudmusic.test.TestActivity;
import com.journeyapps.barcodescanner.Util;

import java.util.function.LongToDoubleFunction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author winiymissl
 * @Date 2023-11-05 13:05
 * @Version 1.0
 */
public class MineViewModel extends ViewModel {
    private MutableLiveData<LoginResult.AccountInfoResult> userData = new MutableLiveData<>();
    private MutableLiveData<PlayListResult.UserPlayListResult> playlist = new MutableLiveData<>();

    private MutableLiveData<PlaylistDetailResult> playlistDetail = new MutableLiveData<>();

    public MutableLiveData<PlaylistDetailResult> getPlaylistDetail() {
        return playlistDetail;
    }

    public MutableLiveData<PlayListResult.UserPlayListResult> getPlaylist() {
        return playlist;
    }

    public void getPlayListInfo(long uid) {
        Utils.SERVICE.getUserPlayList(String.valueOf(uid)).enqueue(new Callback<PlayListResult.UserPlayListResult>() {
            @Override
            public void onResponse(Call<PlayListResult.UserPlayListResult> call, Response<PlayListResult.UserPlayListResult> response) {
                playlist.setValue(response.body());
                Log.d("CheckPlayListInfo", playlist.getValue().getPlaylist().toString());
            }

            @Override
            public void onFailure(Call<PlayListResult.UserPlayListResult> call, Throwable t) {


            }
        });
    }

    public void getPlaylistDetail(long id) {
        Utils.SERVICE.getPlaylistDetail(id).enqueue(new Callback<PlaylistDetailResult>() {
            @Override
            public void onResponse(Call<PlaylistDetailResult> call, Response<PlaylistDetailResult> response) {
                playlistDetail.setValue(response.body());
                Log.d("asdjklfhkajsldhfkajsdfhaks", response.body().toString());
            }

            @Override
            public void onFailure(Call<PlaylistDetailResult> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<LoginResult.AccountInfoResult> getUserData() {
        return userData;
    }

    public void getAccountInfo(String cookie) {
        Utils.SERVICE.getAccountInfo(cookie).enqueue(new Callback<LoginResult.AccountInfoResult>() {
            @Override
            public void onResponse(Call<LoginResult.AccountInfoResult> call, Response<LoginResult.AccountInfoResult> response) {
                //获得用户账号信息,交给viewModel
                userData.setValue(response.body());
                Log.d("CheckInfoWhetherSuccess", userData.getValue().getAccount().toString());
            }

            @Override
            public void onFailure(Call<LoginResult.AccountInfoResult> call, Throwable t) {
                //返回数据失败

            }
        });
    }

}
