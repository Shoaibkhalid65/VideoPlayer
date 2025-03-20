package com.example.videoapi;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class YouTubePlayer extends AppCompatActivity {
    WebView youtubeWebView;
    private String videoId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_player);
        youtubeWebView=findViewById(R.id.youtubeWebView);
        WebSettings webSettings=youtubeWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        videoId = getIntent().getStringExtra(VideoAdapter.KEY_VIDEO_ID);
        youtubeWebView.setWebViewClient(new WebViewClient());
        String videoHtml = "<html><body><iframe width=\"100%\" height=\"100%\" " +
                "src=\"https://www.youtube.com/embed/" + videoId + "?autoplay=1&controls=1\" " +
                "frameborder=\"0\" allowfullscreen></iframe></body></html>";
        youtubeWebView.loadData(videoHtml,"text/html", "utf-8");




    }
}