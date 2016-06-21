package com.example.externalstorage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File dir = Environment.getExternalStorageDirectory();
        File dataFile = new File(dir, "data.txt");

        // read
        try {
            FileInputStream fis = new FileInputStream(dataFile);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fis.close();

            String str = new String(bytes, "utf-8");
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write
//        try {
//            if (!dataFile.exists()) {
//                dataFile.createNewFile();
//            }
//            FileOutputStream fos = new FileOutputStream(dataFile);
//            fos.write(new String("Hello nerd").getBytes("utf-8"));
//            fos.flush();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
