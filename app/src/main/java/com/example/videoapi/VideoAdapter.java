package com.example.videoapi;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    public List<VideoItem> videoItems;
    public static final String KEY_VIDEO_ID="videoId";

    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item_view,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        VideoItem videoItem=videoItems.get(position);
        holder.tvTitle.setText(videoItem.getSnippet().getTitle());
        Picasso.get().load(videoItem.getSnippet().getThumbnails().getMedium().getUrl()).into(holder.ivThumbnail);

        holder.itemView.setOnClickListener(view-> {
            Intent intent=new Intent(view.getContext(), YouTubePlayer.class);
            intent.putExtra(KEY_VIDEO_ID,videoItem.getId().getVideoId());
            view.getContext().startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
         return videoItems.size();
    }

    public  class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbnail;
        TextView tvTitle;
        public VideoViewHolder(@NonNull View itemView){
            super(itemView);
            ivThumbnail=itemView.findViewById(R.id.iv_thumbnail);
            tvTitle=itemView.findViewById(R.id.tv_title);
        }
    }

}
