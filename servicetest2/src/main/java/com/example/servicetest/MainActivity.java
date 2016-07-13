package com.example.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startButton;
    private Button stopButton;
    private Button bindButton;
    private Button unbindButton;

//    private MyService.MyBinder myBinder;

    private IMyAidlService myAidlService;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 将传入的IBinder对象传换成MyAIDLService对象
            myAidlService = IMyAidlService.Stub.asInterface(service);
            try {
                int result = myAidlService.plus(3, 5);
                String upperStr = myAidlService.toUpperCase("hello world");
                Log.d("TAG", "result is " + result);
                Log.d("TAG", "upperStr is " + upperStr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
//            myBinder = (MyService.MyBinder) service;
//            myBinder.startDownload();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Log.d("MyService", "MainActivity thread id is " + Thread.currentThread().getId());
        Log.d("TAG", "process id is " + android.os.Process.myPid());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.start_service);
        stopButton = (Button) findViewById(R.id.stop_service);
        bindButton = (Button) findViewById(R.id.bind_service);
        unbindButton = (Button) findViewById(R.id.unbind_service);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        bindButton.setOnClickListener(this);
        unbindButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                Log.d("MyService", "click Stop Service button");
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bind_service:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                Log.d("MyService", "click Unbind Service button");
                unbindService(connection);
                break;
        }
    }
}
