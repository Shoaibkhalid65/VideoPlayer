package com.example.videoapi;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class YouTubeApiClint {
    public static final String API_KEY="AIzaSyCy5jhuLvvOf1ir3Satd1k3dopeSU8fnO8";
    public static YouTubeApi getYouTubeService(){
        Retrofit retrofit=RetrofitClint.getInstance();
        return retrofit.create(YouTubeApi.class);
    }

}
