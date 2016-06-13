package com.example.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/12.
 */
public class FourActivity extends Activity {

    private TextView textView;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        Intent intent = getIntent();
        if (intent != null) {

//            int[] data = intent.getIntArrayExtra("name");
//            Log.i("Main", "data = " + data);
            Bitmap bitmap = intent.getParcelableExtra("bitmap");
            imageView.setImageBitmap(bitmap);
//            Person person = (Person) intent.getSerializableExtra("person");
//            textView.setText(person.toString());
//            String name = intent.getStringExtra("name");
//            int age = intent.getIntExtra("age", 0);
//            textView.setText("name = " + name + "age = " + age);
        }
    }
}
