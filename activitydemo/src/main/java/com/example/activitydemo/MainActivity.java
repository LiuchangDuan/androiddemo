package com.example.activitydemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "Main";

    private Button button;

    private TextView textView;

    private MediaPlayer mediaPlayer;

    private int position;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "MainActivity onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putString("name", "Lin");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "MainActivity onCreate");
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(this);
        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString("name"));
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.sing);
        mediaPlayer.start();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "MainActivity onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "MainActivity onResume");
        super.onResume();
        if (position != 0) {
            mediaPlayer.seekTo(position);
            mediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "MainActivity onPause");
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            position = mediaPlayer.getCurrentPosition();
        }
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "MainActivity onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "MainActivity onDestroy");
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "MainActivity onRestart");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
