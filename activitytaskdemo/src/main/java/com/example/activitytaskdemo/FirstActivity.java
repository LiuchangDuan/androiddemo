package com.example.activitytaskdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/6/13.
 */
public class FirstActivity extends Activity implements View.OnClickListener {

    private Button button;

    private Button btnStartSelf;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(MainActivity.TAG, "FirstActivity onNewIntent ");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        Log.i(MainActivity.TAG, "FirstActivity taskId " + getTaskId());
        button = (Button) findViewById(R.id.button1);
        btnStartSelf = (Button) findViewById(R.id.btnStartSelf);
        button.setOnClickListener(this);
        btnStartSelf.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnStartSelf:
                Intent intent1 = new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MainActivity.TAG, "FirstActivity onDestroy");
    }

}
