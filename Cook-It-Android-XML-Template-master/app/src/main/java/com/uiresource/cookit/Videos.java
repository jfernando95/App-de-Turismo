package com.uiresource.cookit;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Videos extends AppCompatActivity {
    VideoView lblVideo,lblVideo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        lblVideo=(VideoView)findViewById(R.id.lblvideo);

        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.webm");
        lblVideo.setMediaController((new MediaController(this)));
        lblVideo.setVideoURI(uri);
        lblVideo.requestFocus();
        lblVideo.start();


    }
}
