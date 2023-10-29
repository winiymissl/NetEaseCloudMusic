package com.example.neteasecloudmusic.ui.three;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.ui.ListenSongActivity;
import com.example.neteasecloudmusic.ui.SearchActivity;
import com.example.neteasecloudmusic.ui.adapter.viewpager.HomeFragmentViewPagerAdapter;
import com.example.neteasecloudmusic.ui.lookfragment.HomeInnerFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private ImageButton imageButton_listen_song;
    private ImageButton imageButton_scan;
    private TextView textView_search;
    private ViewPager viewPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        try {
            Toolbar toolbar = view.findViewById(R.id.tb_home_activity);
            imageButton_scan = toolbar.findViewById(R.id.ib_top_scan);
            textView_search = toolbar.findViewById(R.id.tv_top_home_activity);
            imageButton_listen_song = toolbar.findViewById(R.id.ib_top_home_activity);
            ImageButton imageButton = view.findViewById(R.id.ib_top_sheet);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity(), R.style.BottomSheetDialog);
                    View view = getLayoutInflater().inflate(R.layout.bottom_sheetdialog, null);
                    TextView textView_bottomDialog = view.findViewById(R.id.tv_bottom);
                    textView_bottomDialog.setText(new String("世界").repeat(200));
                    bottomSheetDialog.setContentView(view);
                    bottomSheetDialog.show();
                }
            });

            textView_search.setOnClickListener(this);
            imageButton_scan.setOnClickListener(this);
            imageButton_listen_song.setOnClickListener(this);
            TabLayout tabLayout = view.findViewById(R.id.tab_home_activity);
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            List<Fragment> list = new ArrayList<>();
            list.add(new HomeInnerFragment("推荐"));
            list.add(new HomeInnerFragment("排行榜"));
//            list.add(new HomeInnerFragment("助眠"));
//            list.add(new HomeInnerFragment("说唱"));
//            list.add(new HomeInnerFragment("欧美"));
//            list.add(new HomeInnerFragment("电音"));
//            list.add(new HomeInnerFragment("国风"));

            HomeFragmentViewPagerAdapter homeFragmentViewPagerAdapter = new HomeFragmentViewPagerAdapter(getChildFragmentManager(), list);
            viewPager = view.findViewById(R.id.vp_home_fragment);
            viewPager.setAdapter(homeFragmentViewPagerAdapter);
            viewPager.setOffscreenPageLimit(1);
            tabLayout.setupWithViewPager(viewPager);
            for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tab = tabLayout.getTabAt(i);
                if (tab != null) {
                    tab.setText(((HomeInnerFragment) list.get(i)).getName());
                }
            }
//             用于viewpager2
//            new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
//
//                @Override
//                public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                    HomeInnerFragment homeInnerFragment = (HomeInnerFragment) list.get(position);
//                    tab.setText(homeInnerFragment.getName());
//                }
//            }).attach();
        } catch (Exception e) {
            Log.d("FragmrntFragment", e.toString());
        }
        return view;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ib_top_home_activity) {
            Intent intent = new Intent(getActivity(), ListenSongActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.ib_top_scan) {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            startActivity(intent);
        }
        if (v.getId() == R.id.tv_top_home_activity) {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        }
    }
}