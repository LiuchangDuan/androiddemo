package com.example.asynctaskdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/6/8.
 */
public class ImageTest extends Activity {

    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private static String URL = "http://img.blog.csdn.net/20160527112422963";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        mImageView = (ImageView) findViewById(R.id.image);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        // 设置传递进去的参数
        new MyAsyncTask().execute(URL);
    }

    // <url类型, 进度值类型, 返回值类型>
    class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE); // 显示进度条
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mProgressBar.setVisibility(View.GONE);
            // 操作UI 设置图像
            mImageView.setImageBitmap(bitmap);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            // 获取传递进来的参数
            String url = params[0]; // 取出对应URL
            Bitmap bitmap = null;
            URLConnection connection; // 定义网络连接对象
            InputStream inputStream; // 用于获取数据的输入流
            try {
                // 获取网络连接对象
                connection = new URL(url).openConnection();
                // 获取输入流
                inputStream = connection.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                Thread.sleep(3000);
                // 将输入流解析成bitmap
                // 通过decodeStream方法解析输入流
                bitmap = BitmapFactory.decodeStream(bis);
                inputStream.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 将Bitmap作为返回值
            return bitmap;
        }

    }

}
