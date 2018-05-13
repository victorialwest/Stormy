package com.example.victoriawest.stormy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG =MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "80cc6a0ebfc0208808d0a822d4758789";
        double lattitude = 37.8267;
        double longitude = -122.4233;

        String forecastURL = "https://api.darksky.net/forecast/" + apiKey + "/" + lattitude + "," + longitude;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(forecastURL).build();
        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                Log.v(TAG, response.body().string());
            }

        } catch (IOException e) {
            Log.e(TAG, "IO Exception caught: ", e);
        }
    }
}
