package com.example.videoapi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String API_KEY="AIzaSyCy5jhuLvvOf1ir3Satd1k3dopeSU8fnO8";
    RecyclerView recyclerView;
    VideoAdapter videoAdapter;
    EditText edInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_video);
        edInput=findViewById(R.id.ed_input);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchVideos("AI in android");
        edInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH||event!=null&&event.getKeyCode()==KeyEvent.KEYCODE_ENTER&&event.getAction()==KeyEvent.ACTION_DOWN){
                    String userInput=edInput.getText().toString();
                    fetchVideos(userInput);
                }
                return true;
            }
        });



    }
    public void fetchVideos(String query){
        Retrofit  retrofit=RetrofitClint.getInstance();
        YouTubeApi youTubeApi=retrofit.create(YouTubeApi.class);
        Call<YouTubeResponse> call=youTubeApi.searchVideos("snippet", query, "video",API_KEY, 100);
        call.enqueue(new Callback<YouTubeResponse>() {
            @Override
            public void onResponse(Call<YouTubeResponse> call, Response<YouTubeResponse> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    List<VideoItem> videoItems=response.body().getVideoItemList();
                    videoAdapter=new VideoAdapter(videoItems);
                    recyclerView.setAdapter(videoAdapter);
                }else{
                    Toast.makeText(MainActivity.this, "response is not successful", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<YouTubeResponse> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Onfailure "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}