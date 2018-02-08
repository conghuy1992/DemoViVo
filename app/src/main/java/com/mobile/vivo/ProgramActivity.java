package com.mobile.vivo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.mobile.vivo.Common.Const;
import com.mobile.vivo.Common.interfaces.OnRotationVideoViewListener;
import com.mobile.vivo.View.FullScreenMediaController;

/**
 * Created by android on 27/12/2017.
 */

public class ProgramActivity extends Activity implements View.OnClickListener {
    private String TAG = "ProgramActivity";
    private Context context;
    private ProgressBar progress_bar;
    private VideoView videoview;
    private String VideoURL = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
    private MediaPlayer mediaPlayer;
    private FullScreenMediaController mediacontroller;
    private boolean isFullScreen = false;
    private FrameLayout frVideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.program_layout);
        context = this;
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
////            getSupportActionBar().setTitle(Const.getMsg(context, R.string.history));
////            getSupportActionBar().setTitle(title);
//        }
        initView();
    }

    private void setHeightVideoView(boolean b) {
        int height= Const.getDimenInPx(context,R.dimen.video_height);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                b?LinearLayout.LayoutParams.MATCH_PARENT:height);
        frVideo.setLayoutParams(params);

        FrameLayout.LayoutParams paramsVideo = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                b?FrameLayout.LayoutParams.MATCH_PARENT:height);
        videoview.setLayoutParams(paramsVideo);
    }

    private void initView() {

        frVideo = (FrameLayout) findViewById(R.id.frVideo);

        progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
        // Find your VideoView in your video_main.xml layout
        videoview = (VideoView) findViewById(R.id.VideoView);
        try {
            // Start the MediaController
            mediacontroller = new FullScreenMediaController(this, new OnRotationVideoViewListener() {
                @Override
                public void onRotation() {
                    isFullScreen = isFullScreen ? false : true;
//                    showMsg("onRotation:" + isFullScreen);
                    mediacontroller.setImageFullScreen(isFullScreen);
                    setRequestedOrientation(isFullScreen ? ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE : ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//                    setContentView(isFullScreen?R.layout.activity_main_l:R.layout.activity_main);
                    setHeightVideoView(isFullScreen);
                }
            });
            mediacontroller.setAnchorView(videoview);
            videoview.setMediaController(mediacontroller);

            // Get the URL from String VideoURL
            Uri video = Uri.parse(VideoURL);

            videoview.setVideoURI(video);

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer = mp;
                progress_bar.setVisibility(View.GONE);
                videoview.start();

                setHeightVideoView(false);

//                 When video Screen change size.
//                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
//                    @Override
//                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
//
//                        // Re-Set the videoView that acts as the anchor for the MediaController
//                        mediacontroller.setAnchorView(videoview);
//                    }
//                });
            }
        });


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pause();
    }

    void resume() {
        if (videoview != null) {
            videoview.seekTo(stopPosition);
        }
    }

    int stopPosition = 0;

    void pause() {
        stopPosition = videoview.getCurrentPosition(); //stopPosition is an int
        if (videoview.isPlaying()) {
            videoview.pause();
        }
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                break;
//        }
//        return false;
//    }

    @Override
    public void onClick(View v) {
    }
}
