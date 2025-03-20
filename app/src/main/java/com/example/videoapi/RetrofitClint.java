package com.example.videoapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {
    public static final String BASE_URL="https://www.googleapis.com/youtube/v3/";
    private static Retrofit instance;

    public static Retrofit getInstance() {
        if(instance==null){
            instance=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
