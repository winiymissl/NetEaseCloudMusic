package com.example.neteasecloudmusic.ui.minefragment;

import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.FragmentMineInnerBinding;

/**
 * @Author winiymissl
 * @Date 2023-10-29 13:36
 * @Version 1.0
 */
public class MineInnerFragment extends Fragment {
    private String name;

    public MineInnerFragment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    FragmentMineInnerBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_inner, container, false);
        FragmentMineInnerBinding.bind(view);
        setEnterTransition(TransitionInflater.from(container.getContext()).inflateTransition(R.transition.slide));
        return view;
    }
}
