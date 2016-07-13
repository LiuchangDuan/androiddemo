package com.example.servicetest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Administrator on 2016/7/13.
 */
public class MyService extends Service {

    NotificationManager manager; // 通知控制类
    int notification_ID = 1;

    public static final String TAG = "MyService";

    private MyBinder mBinder = new MyBinder();

    @Override
    public void onCreate() {
        Log.d("MyService", "MyService thread id is " + Thread.currentThread().getId());
        super.onCreate();
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher); // 设置图标
        builder.setTicker("hello"); // 手机状态栏的提示
        builder.setWhen(System.currentTimeMillis()); // 设置时间
        builder.setContentTitle("通知栏通知"); // 设置标题
        builder.setContentText("我来自MyService"); // 设置通知内容
        builder.setContentIntent(pendingIntent); // 点击后的意图
        builder.setDefaults(Notification.DEFAULT_SOUND); // 设置提示声音
        builder.setDefaults(Notification.DEFAULT_LIGHTS); // 设置指示灯 需要权限
        builder.setDefaults(Notification.DEFAULT_VIBRATE); // 设置震动效果 需要权限
        builder.setDefaults(Notification.DEFAULT_ALL);
        Notification notification = builder.build(); // 4.1以上 （android:minSdkVersion="16"以上）
//        builder.getNotification(); // 4.1以下
        manager.notify(notification_ID, notification);

//        //  duplicate
//        Notification notification = new Notification(R.mipmap.ic_launcher, "有通知到来", System.currentTimeMillis());
//        Intent notificationIntent = new Intent(this, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
//        notification.setLates
        Log.d(TAG, "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    class MyBinder extends Binder {
        public void startDownload() {
            Log.d(TAG, "startDownload() executed");
        }
    }

}
