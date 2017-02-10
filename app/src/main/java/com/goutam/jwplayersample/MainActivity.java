package com.goutam.jwplayersample;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.longtailvideo.jwplayer.JWPlayerFragment;
import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.events.listeners.VideoPlayerEvents;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

public class MainActivity extends AppCompatActivity {
    JWPlayerView playerView = null;
    private static final String VIDEO_URL = "http://164.164.34.71:3001/api/candidateMobileSeeVideoProfileFile/585225de1848df1e3c140477.mp4";
    private static final String VIDEO_URI = "file:///storage/emulated/0/Movies/valYou/videoProfile.mp4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get a handle to the JWPlayerFragment
        JWPlayerFragment fragment = (JWPlayerFragment) getFragmentManager().findFragmentById(R.id.playerFragment);

        // Get a handle to the JWPlayerView
        playerView = fragment.getPlayer();
        //"http://clips.vorwaerts-gmbh.de/VfE_html5.mp4"
        // Create a PlaylistItem
        PlaylistItem video = new PlaylistItem(VIDEO_URL);

        // Load a stream into the player

        playerView.load(video);

        /*VideoPlayerEvents.OnFullscreenListener fullScreenUiUpdator = new VideoPlayerEvents.OnFullscreenListener() {
            @Override
            public void onFullscreen(boolean b) {
                if (b) {
                    getActionBar().hide();
                    findViewById(R.id.cross).setVisibility(View.VISIBLE);
                } else {
                    getActionBar().show();
                    findViewById(R.id.cross).setVisibility(View.GONE);
                }


*//*
/////
    *//**//*
        If the root layout of this activity is the coordinator layout (default for new projects created in Android Studio 2.0+)
        Then we also want to unset fitsSystemWindows
    *//**//*
                ((CoordinatorLayout)findViewById({ID_OF_ROOT_LAYOUT})).setFitsSystemWindows(!state);*//*

            }
        };*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Let JW Player know that the app has returned from the background
        playerView.onResume();
    }

    @Override
    protected void onPause() {
        // Let JW Player know that the app is going to the background
        super.onPause();
        playerView.onPause();
    }

    @Override
    protected void onDestroy() {
        // Let JW Player know that the app is being destroyed
        playerView.onDestroy();
        super.onDestroy();
    }

    // Set fullscreen when the device is rotated to landscape
    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        playerView.setFullscreen(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE, true);
        super.onConfigurationChanged(newConfig);
    }

    // Exit fullscreen when the user pressed the Back button
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (playerView.getFullscreen()) {
                playerView.setFullscreen(false, false);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


}
