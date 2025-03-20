package com.example.videoapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YouTubeApi {
    String END_POINT="search";
    @GET (END_POINT)
    Call<YouTubeResponse>searchVideos(@Query("part") String part,
                                       @Query("q") String query,
                                       @Query("type") String type,
                                       @Query("key") String apiKey,
                                       @Query("maxResults") int maxResults
                                       );
}
