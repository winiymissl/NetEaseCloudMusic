package com.example.neteasecloudmusic.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.ActivityTestBinding;
import com.example.neteasecloudmusic.ui.minefragment.MineInnerFragment;

import retrofit2.http.Tag;

/**
 * @author winiymissl
 */
public class TestActivity extends AppCompatActivity {
    ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.bind(LayoutInflater.from(this).inflate(R.layout.activity_test, null, false));
        setContentView(binding.getRoot());

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//                    binding.btn.setVisibility(View.GONE);
//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    MineInnerFragment myFragment = new MineInnerFragment();
//                    FragmentTransaction transaction = fragmentManager.beginTransaction();
//                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                    transaction.replace(R.id.test, myFragment);
//                    transaction.addToBackStack(null);
//                    transaction.commit();
                } catch (Exception e) {
                    Log.d("IChangeSoMuch", e.toString());
                }
            }
        });
    }
}