package com.example.neteasecloudmusic.ui.minefragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioRouting;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.FragmentPlayBinding;
import com.example.neteasecloudmusic.logic.network.Utils;
import com.example.neteasecloudmusic.logic.network.entities.PlayListResult;
import com.example.neteasecloudmusic.logic.network.entities.SongBean;
import com.example.neteasecloudmusic.logic.network.entities.SongDetailResult;
import com.example.neteasecloudmusic.logic.network.global.Global;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author winiymissl
 * @Date 2023-11-06 22:00
 * @Version 1.0
 */
public class PlayFragment extends Fragment {
    FragmentPlayBinding binding;
    PlayListResult.TrackId songBean;

    private MediaPlayer mediaPlayer;
    private Handler handler;

    //    private MediaPlayer mediaPlayer;

    public PlayFragment(PlayListResult.TrackId songBean) {
        this.songBean = songBean;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play, container, false);
        binding = FragmentPlayBinding.bind(view);
        binding.ibPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStack(); // 弹出上一个Fragment

            }
        });
        binding.fragmentPlayRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setEnterTransition(TransitionInflater.from(container.getContext()).inflateTransition(R.transition.slide));
        Utils.SERVICE.getSongDetail(String.valueOf(songBean.getId())).enqueue(new Callback<SongDetailResult>() {

            private boolean isImageChanged = false;

            @Override
            public void onResponse(Call<SongDetailResult> call, Response<SongDetailResult> response) {
                SongBean song = response.body().getSongs().get(0);
                binding.tvToolbar.setText(song.getName());
                binding.tvToolbarUp2.setText(song.getAr().toString());


                Glide.with(getActivity()).load(song.getAl().getPicUrl()).apply(new RequestOptions().transform(new BlurTransformation(100, 3))).into(binding.playBackgrounnd);
                Log.d("IWantTheWorldPeace", song.toString());
                //返回歌曲的uri，接下来，准备使用播放器，将歌曲的uri，直接进行播放
                Utils.SERVICE.getSongUrl(song.getId(), "exhigh").enqueue(new Callback<SongBean.SongUrlBean>() {
                    @Override
                    public void onResponse(Call<SongBean.SongUrlBean> call, Response<SongBean.SongUrlBean> response) {
                        try {
                            mediaPlayer = Global.getMediaPlayer();
                            mediaPlayer.reset();
                            Log.d("SongUrl", response.body().toString());
                            String uri = response.body().getData().get(0).getUrl();
                            if (uri == null) {
                                Log.d("SongUrl", "uri为空");
                            }
                            mediaPlayer.setDataSource(uri);
                            mediaPlayer.prepareAsync();
                            Log.d("shjienihao", String.valueOf(song.getDt()));
                            handler = new Handler();
                            Runnable updateSeekBar = new Runnable() {
                                @Override
                                public void run() {
                                    if (mediaPlayer != null) {
                                        int currentPosition = mediaPlayer.getCurrentPosition();
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                binding.seekBarPlay.setProgress(currentPosition);
                                                binding.tvTimeStart.setText(String.format("%02d:%02d", currentPosition / 60000, currentPosition / 1000 % 60));
                                            }
                                        });
                                    }
                                    // 延迟一段时间后再次运行
                                    handler.postDelayed(this, 500); // 这里将每秒更新一次进度
                                }
                            };

                            //准备方法
                            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mp) {
                                    mp.start();
                                    binding.btnPlay.setImageResource(R.drawable.play);
                                    handler.post(updateSeekBar);
                                }
                            });
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "网络拥挤", Toast.LENGTH_SHORT).show();
                            Log.d("playFail", e.toString());
                        }
                        binding.btnPlay.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // 用于跟踪图片状态

                                if (isImageChanged) {
                                    // 如果图片已经更改，还原为初始图片
                                    binding.btnPlay.setImageResource(R.drawable.play);
                                    mediaPlayer.start();
                                } else {
                                    // 如果图片未更改，切换到新的图片
                                    binding.btnPlay.setImageResource(R.drawable.pause);
                                    mediaPlayer.pause();
                                }
                                // 切换图片状态
                                isImageChanged = !isImageChanged;
                            }
                        });
                        //切换路由设备
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//                            mediaPlayer.addOnRoutingChangedListener(new AudioRouting.OnRoutingChangedListener() {
//                                @Override
//                                public void onRoutingChanged(AudioRouting router) {
//
//                                }
//                            }, new Handler());
//                        }
                        //发生错误的监听
//                        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//                            @Override
//                            public boolean onError(MediaPlayer mp, int what, int extra) {
//                                Toast.makeText(getActivity(), "播放错误", Toast.LENGTH_SHORT).show();
//                                return true; // 返回 true 表示已处理错误，返回 false 表示未处理错误
//                            }
//                        });

                        //进度条的相关设置
                        //进度条发生改变的监听器
                        binding.seekBarPlay.setMax(song.getDt());
                        binding.seekBarPlay.setMin(0);
                        int time = song.getDt();
                        binding.tvTimeEnd.setText(String.format("%02d:%02d", time / 60000, time / 1000 % 60));
                        binding.tvTimeStart.setText(String.format("00:00"));
//                      binding.tvTimeEnd.setText(String.valueOf(binding.seekBarPlay.getMax()));
//                      binding.tvTimeStart.setText(String.valueOf(binding.seekBarPlay.getMin()));
                        binding.seekBarPlay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                            @Override
                            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                if (fromUser) {
                                    mediaPlayer.seekTo(progress);
                                }
                            }

                            @Override
                            public void onStartTrackingTouch(SeekBar seekBar) {
                                //暂停播放
                                mediaPlayer.pause();
                            }

                            @Override
                            public void onStopTrackingTouch(SeekBar seekBar) {
                                //开始播放
                                mediaPlayer.start();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<SongBean.SongUrlBean> call, Throwable t) {
//                        Toast.makeText(getActivity(), "播放失败" + t.toString(), Toast.LENGTH_SHORT).show();
                        Log.d("asdfasdfasd", "onFailure: " + t.toString());
                    }
                });
            }

            @Override
            public void onFailure(Call<SongDetailResult> call, Throwable t) {

            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mediaPlayer.stop();
//        mediaPlayer.release();
        //关闭
        handler.removeCallbacksAndMessages(null);
    }
}
