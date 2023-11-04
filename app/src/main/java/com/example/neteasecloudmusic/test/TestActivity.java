package com.example.neteasecloudmusic.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.neteasecloudmusic.R;
import com.example.neteasecloudmusic.databinding.ActivityTestBinding;
import com.example.neteasecloudmusic.logic.network.Utils;
import com.example.neteasecloudmusic.logic.network.apiservice.ApiService;
import com.example.neteasecloudmusic.logic.network.entities.LoginResult;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TestActivity extends AppCompatActivity {
    ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.104:3000/").addConverterFactory(GsonConverterFactory.create()).build();

                Utils.SERVICE.getLoginQrcodeKey(new Date().toString()).enqueue(new Callback<LoginResult.QrcodeKeyResult>() {
                    @Override
                    public void onResponse(Call<LoginResult.QrcodeKeyResult> call, Response<LoginResult.QrcodeKeyResult> response) {
                        Log.d("WhereDoYouWantToGo", response.body().getBean().toString());
                        createQr(response);
                    }

                    @Override
                    public void onFailure(Call<LoginResult.QrcodeKeyResult> call, Throwable t) {
                        Log.d("WhereDoYouWantToGo", t.toString());
                    }
                });
            }
        });
    }

    private void createQr(Response<LoginResult.QrcodeKeyResult> response) {
        Utils.SERVICE.getLoginQrcodeValue(response.body().getBean().getKey(), new Date().toString()).enqueue(new Callback<LoginResult.QrcodeValueResult>() {
            @Override
            public void onResponse(Call<LoginResult.QrcodeValueResult> call, Response<LoginResult.QrcodeValueResult> response) {
                QRCodeWriter qrCodeWriter = new QRCodeWriter();
//                qrCodeWriter.encode(response.body().getBean().getQrUrl(), );
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

            }
        });
    }
}