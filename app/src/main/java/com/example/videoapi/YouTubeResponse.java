package com.example.videoapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YouTubeResponse {
    @SerializedName("items")
    private List<VideoItem> items;
    public List<VideoItem> getVideoItemList() {
        return items;
    }
}
