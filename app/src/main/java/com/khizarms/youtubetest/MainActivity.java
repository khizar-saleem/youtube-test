package com.khizarms.youtubetest;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

  YouTubePlayerView youTubePlayerView;
  OnInitializedListener onInitializedListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    youTubePlayerView = findViewById(R.id.yt_player_view);
    onInitializedListener = new OnInitializedListener() {
      @Override
      public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer,
          boolean b) {
        youTubePlayer.loadVideo("b0U8EyHR4_Y");
      }

      @Override
      public void onInitializationFailure(Provider provider,
          YouTubeInitializationResult youTubeInitializationResult) {

      }
    };
    youTubePlayerView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        youTubePlayerView.initialize(PlayerConfig.API_KEY, onInitializedListener);
      }
    });
  }

}
