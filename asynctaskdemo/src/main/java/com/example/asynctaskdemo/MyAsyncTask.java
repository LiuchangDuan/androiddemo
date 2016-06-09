package com.example.asynctaskdemo;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/8.
 */
public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    //必须实现
    @Override
    protected Void doInBackground(Void... params) {
        Log.d("Main", "doInBackground");
        publishProgress(); // 传入进度值
        return null;
    }

    @Override
    protected void onPreExecute() {
        Log.d("Main", "onPreExecute");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        Log.d("Main", "onPostExecute");
        super.onPostExecute(aVoid);
    }

    // 获取进度，更新进度条
    @Override
    protected void onProgressUpdate(Void... values) {
        Log.d("Main", "onProgressUpdate");
        super.onProgressUpdate(values);
    }

}
