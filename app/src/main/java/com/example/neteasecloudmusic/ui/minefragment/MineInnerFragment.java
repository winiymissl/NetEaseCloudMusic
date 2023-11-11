package com.example.neteasecloudmusic.ui.minefragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.FragmentMineInnerBinding;
import com.example.neteasecloudmusic.logic.network.Utils;
import com.example.neteasecloudmusic.logic.network.entities.PlayListResult;
import com.example.neteasecloudmusic.logic.network.entities.PlaylistDetailResult;
import com.example.neteasecloudmusic.ui.adapter.myrecyclerview.RecyclerItemClickListener;
import com.example.neteasecloudmusic.ui.adapter.recyclerview.SongListRecyclerViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author winiymissl
 * @Date 2023-10-29 13:36
 * @Version 1.0
 */
public class MineInnerFragment extends Fragment {
    PlayListResult.PlaylistBean playlistBean;
    private List<PlayListResult.TrackId> songs;

    public MineInnerFragment(PlayListResult.PlaylistBean playlistBean) {
        this.playlistBean = playlistBean;
    }

    FragmentMineInnerBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_inner, container, false);
        binding = FragmentMineInnerBinding.bind(view);
//        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.gradient);
//        binding.tbMineActivity.startAnimation(animation);
//        setEnterTransition(TransitionInflater.from(container.getContext()).inflateTransition(R.transition.slide));
        Glide.with(getActivity()).load(playlistBean.getCoverImgUrl()).apply(RequestOptions.bitmapTransform(new BlurTransformation(100, 5))).into(binding.ivMineSongListBack);
        Glide.with(getActivity()).load(playlistBean.getCoverImgUrl()).into(binding.ivHeadImageList);
        Glide.with(getActivity()).load(playlistBean.getCreator().getAvatarUrl()).into(binding.ivUserImageSongList);
        binding.tvUserNameSongList.setText(playlistBean.getCreator().getNickname());
        binding.tvMineInnerListName.setText(playlistBean.getName());
        binding.songlistBofang.setText("播放" + "(" + playlistBean.getPlayCount() + ")");
        binding.songlistPinglun.setText("评论" + "(" + playlistBean.getCommentCount() + ")");
        binding.songlistFenxiang.setText("分享" + "(" + playlistBean.getShareCount() + ")");
        binding.playSongList.setText("播放全部" + "(" + playlistBean.getTrackCount() + ")");

        binding.rvSongList.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                try {
//                    BottomNavigationView bottom = getActivity().findViewById(R.id.bottomNav_home_activity);
//                    AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(), R.animator.slide_down);
//                    animatorSet.setTarget(bottom);
//                    animatorSet.start();
                } catch (Exception e) {
                    Log.d("CheckIsSuccess  ", e.toString());

                }
//                Utils.SERVICE.getSongDetail(playlistBean.getTrackIds())
                Toast.makeText(getActivity(), "点击了歌曲", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.add(R.id.home_frame, new PlayFragment(songs.get(position)));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }));
        binding.ibMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //结束当前的碎片
//                getActivity().getSupportFragmentManager().beginTransaction().remove(Fragment.this).commit();

            }
        });
        if (playlistBean.getDescription() == null) {
            binding.tvDescSongList.setText("暂无描述");
        } else {
            binding.tvDescSongList.setText(playlistBean.getDescription());
        }

        Utils.SERVICE.getPlaylistDetail(playlistBean.getId()).enqueue(new Callback<PlaylistDetailResult>() {
            @Override
            public void onResponse(Call<PlaylistDetailResult> call, Response<PlaylistDetailResult> response) {
                //设置一个停止加载
                /*
                 *
                 * */
                Log.d("shijieniaho", response.body().getPlaylist().getTrackIds().toString());
                songs = response.body().getPlaylist().getTrackIds();
                RecyclerView recyclerView = binding.rvSongList;
                SongListRecyclerViewAdapter songListRecyclerViewAdapter = new SongListRecyclerViewAdapter(response.body().getPlaylist().getTracks());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(songListRecyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<PlaylistDetailResult> call, Throwable t) {

            }
        });
        return view;
    }
}
