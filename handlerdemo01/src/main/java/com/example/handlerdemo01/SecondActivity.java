package com.example.handlerdemo01;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2016/6/18.
 */
public class SecondActivity extends Activity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // threadlocal set get

        // ActivityThread main Looper message
//        handler.sendEmptyMessage();
//        Looper

    }

}
