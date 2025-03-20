package com.example.videoapi;


import com.google.gson.annotations.SerializedName;

public class VideoItem {
    @SerializedName("id")
    private VideoId id;
    @SerializedName("snippet")
    private Snippet snippet;

    public VideoId getId() {
        return id;
    }
    public Snippet getSnippet() {
        return snippet;
    }

    public static class VideoId{
        @SerializedName("videoId")
        private String videoId;

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }
    }
    public static class Snippet{
        @SerializedName("title")
        private String title;
        @SerializedName("thumbnails")
        private Thumbnails thumbnails;

        public String getTitle() {
            return title;
        }

        public Thumbnails getThumbnails() {
            return thumbnails;
        }
    }
    public static class Thumbnails{
        @SerializedName("medium")
        private ThumbnailImage medium;

        public ThumbnailImage getMedium() {
            return medium;
        }
    }
    public static class ThumbnailImage{
        @SerializedName("url")
        private String url;

        public String getUrl() {
            return url;
        }
    }
}
