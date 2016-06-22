package com.example.usingsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/6/21.
 */
public class Db extends SQLiteOpenHelper {

//    public Db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, "db", null, 1);
//    }


    public Db(Context context) {
        super(context, "db", null, 1);
    }

    // \"\"等同于NONE
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(" +
                "name TEXT DEFAULT \"\"," +
                "sex TEXT DEFAULT \"\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
