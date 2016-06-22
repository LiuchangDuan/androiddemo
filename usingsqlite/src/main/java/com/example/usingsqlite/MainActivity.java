package com.example.usingsqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Db db = new Db(this);
        SQLiteDatabase dbWrite = db.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", "zhangsan");
        cv.put("sex", "mtf");
        dbWrite.insert("user", null, cv);

        cv = new ContentValues();
        cv.put("name", "lisi");
        cv.put("sex", "ftm");
        dbWrite.insert("user", null, cv);

    }
}
