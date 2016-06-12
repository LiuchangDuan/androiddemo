package com.example.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/6/12.
 */
public class ThreeActivity extends Activity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(ThreeActivity.this, FourActivity.class);
        Intent intent = new Intent();
//        ComponentName componentName = new ComponentName(ThreeActivity.this, FourActivity.class);
//        intent.setComponent(componentName);
//        intent.setAction("www.lin.com");
//        intent.setAction(Intent.ACTION_VIEW);
//        Uri uri = Uri.parse("http://www.baidu.com");
//        intent.setData(uri);
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        intent.setType("image/*");
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_TEXT, "I am mtf");
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("tel:123456");
        intent.setData(uri);
        startActivity(intent);
    }

}
