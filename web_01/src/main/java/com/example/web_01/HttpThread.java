package com.example.web_01;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/6/10.
 */
public class HttpThread extends Thread {

    private String mUrl;

    public HttpThread(String url) {
        this.mUrl = url;
    }

    @Override
    public void run() {

        try {

            System.out.println("start download");

            URL httpUrl = new URL(mUrl);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setDoInput(true);
//            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            InputStream in = conn.getInputStream();
            File downloadFile;
            File sdFile;

            FileOutputStream out = null;
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                downloadFile = Environment.getExternalStorageDirectory();
                sdFile = new File(downloadFile, "test.apk");
                out = new FileOutputStream(sdFile);
            }

            byte[] b = new byte[6 * 1024];
            int len;

            while ((len = in.read(b)) != -1) {
                if (out != null) {
                    out.write(b, 0, len);
                }
            }

            if (out != null) {
                out.close();
            }

            if (in != null) {
                in.close();
            }

            System.out.println("download success");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
