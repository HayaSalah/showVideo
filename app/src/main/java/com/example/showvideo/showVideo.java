package com.example.showvideo;

import androidx.appcompat.app.AppCompatActivity;


import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class showVideo extends AppCompatActivity {
    private PlayerView playerView;
    private String videoUrl;
    SimpleExoPlayer player;
    private boolean playWhenReady = true;
    private long playPackPosition = 0;
    private int currentWindow = 0;

    String uri1="https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_480_1_5MG.mp4";
     String uri2 ="https://www.youtube.com/watch?v=5mB5Yw5fGww&t=118s";
     String uri3 ="https://www.youtube.com/watch?v=BD95BJZKJtc";
     String uri4 ="https://www.youtube.com/watch?v=0_t5HYJNPsU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_video);
        playerView = findViewById(R.id.viedo_view);
        String recUrl = getIntent().getStringExtra("uri");

        if (recUrl.equals(uri1)) {
            videoUrl = uri1;
        } else if (recUrl.equals(uri2)) {
            videoUrl = uri2;
        } else if (recUrl.equals(uri3)){
            videoUrl = uri3;
        }else if (recUrl.equals(uri4)){
            videoUrl = uri4;
        }



    }
    private void releaseVideo() {
        if (player != null) {
            playWhenReady = player.getPlayWhenReady();
            playPackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            player.release();
            player = null;

        }
    }

    private void initVideo() {
        player = ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(player);

        Uri uri = Uri.parse(videoUrl);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this , "Ass-4");
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri);

        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow,playPackPosition);
        player.prepare(mediaSource,false,false);

    }



    @Override
    protected void onStart() {
        super.onStart();
        initVideo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseVideo();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (player != null) {
//            initVideo();
//        }
//    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseVideo();
    }
}

