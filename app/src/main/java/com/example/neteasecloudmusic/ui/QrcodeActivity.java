package com.example.neteasecloudmusic.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.neteasecloudmusic.databinding.ActivityQrcodeBinding;
import com.example.neteasecloudmusic.logic.network.Code;
import com.example.neteasecloudmusic.logic.network.Utils;
import com.example.neteasecloudmusic.logic.network.entities.LoginResult;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QrcodeActivity extends AppCompatActivity {
    ActivityQrcodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQrcodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.testProBar.setVisibility(View.INVISIBLE);
        binding.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.testProBar.setVisibility(View.VISIBLE);
                Utils.SERVICE.getLoginQrcodeKey(System.currentTimeMillis()).enqueue(new Callback<LoginResult.QrcodeKeyResult>() {
                    @Override
                    public void onResponse(Call<LoginResult.QrcodeKeyResult> call, Response<LoginResult.QrcodeKeyResult> response) {
                        Log.d("WhereDoYouWantToGo", response.body().getData().getUnikey());
                        createQr(response);
                        checkLoginStatus(response);
                    }

                    @Override
                    public void onFailure(Call<LoginResult.QrcodeKeyResult> call, Throwable t) {
                        Log.d("WhereDoYouWantToGo", t.toString());
                    }
                });
            }
        });
    }

    private void checkLoginStatus(Response<LoginResult.QrcodeKeyResult> response) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
// 创建一个定期执行的任务
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Utils.SERVICE.checkQrcodeAuthStatus(response.body().getData().getUnikey(), System.currentTimeMillis()).enqueue(new Callback<LoginResult.QrcodeAuthResult>() {
                    @Override
                    public void onResponse(Call<LoginResult.QrcodeAuthResult> call, Response<LoginResult.QrcodeAuthResult> response) {
                        int code = response.body().getCode();
                        Log.d("LoginThing", String.valueOf(code));
                        if (code == Code.LOGIN_SUCCESS) {
                            // 当响应的 code 等于 803 时，可以停止定时任务
                            //同时检测是否登陆过
                            scheduler.shutdown();
                            //将数据交给viewModel
                            SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("cookie", response.body().getCookie());
                            editor.commit();//同步提交
                            //打开新栈s

                            Intent intent = new Intent(QrcodeActivity.this, HomeActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult.QrcodeAuthResult> call, Throwable t) {
                        // 请求失败处理
                    }
                });
            }
        };
        // 延迟0秒后，每隔2秒执行一次任务
        scheduler.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }

    //    private void getAccountInfo(Response<LoginResult.QrcodeAuthResult> response) {
//        Utils.SERVICE.getAccountInfo(response.body().getCookie()).enqueue(new Callback<LoginResult.AccountInfoResult>() {
//            @Override
//            public void onResponse(Call<LoginResult.AccountInfoResult> call, Response<LoginResult.AccountInfoResult> response) {
//                //获得用户账号信息,交给viewModel
//                MineViewModel model = new ViewModelProvider(QrcodeActivity.this).get(MineViewModel.class);
//                model.userData.setValue(response.body());
//                Log.d("CheckInfoWhetherSuccess", model.getUserData().getValue().getAccount().toString());
//            }
//
//            @Override
//            public void onFailure(Call<LoginResult.AccountInfoResult> call, Throwable t) {
//                //返回数据失败
//            }
//        });
//    }
    private void createQr(Response<LoginResult.QrcodeKeyResult> response) {
        Utils.SERVICE.getLoginQrcodeValue(response.body().getData().getUnikey(), System.currentTimeMillis()).enqueue(new Callback<LoginResult.QrcodeValueResult>() {
            @Override
            public void onResponse(Call<LoginResult.QrcodeValueResult> call, Response<LoginResult.QrcodeValueResult> response) {
                binding.testProBar.setVisibility(View.GONE);
                binding.ivTest.setVisibility(View.VISIBLE);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                try {
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(response.body().getBean().getQrurl(), BarcodeFormat.QR_CODE, 400, 400);
                    binding.ivTest.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    Log.d("LoginProblem", e.toString());
                }
            }

            @Override
            public void onFailure(Call<LoginResult.QrcodeValueResult> call, Throwable t) {
                Log.d("LoginProblem", t.toString());
            }
        });
    }
}