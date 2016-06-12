package com.example.activitydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/12.
 */
public class SecondActivity extends Activity {

    public static final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "SecondActivity onCreate");
        setContentView(R.layout.second);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "SecondActivity onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "SecondActivity onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "SecondActivity onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "SecondActivity onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "SecondActivity onDestroy");
        super.onDestroy();
    }

}
