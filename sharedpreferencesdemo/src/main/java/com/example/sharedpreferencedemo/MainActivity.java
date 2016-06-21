package com.example.sharedpreferencedemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox cb;

    private SharedPreferences sp;

    private static final String KEY_SHOW_DIALOG_AT_START = "showWelcomeDialogAtStart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp =  getSharedPreferences("mysp", Context.MODE_PRIVATE);

        cb = (CheckBox) findViewById(R.id.cb);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor e = sp.edit();
                e.putBoolean(KEY_SHOW_DIALOG_AT_START, isChecked);
                e.commit();
            }
        });

        cb.setChecked(sp.getBoolean(KEY_SHOW_DIALOG_AT_START, false));

        if (cb.isChecked()) {
            new AlertDialog.Builder(this).setTitle("hello").setMessage("hello nerd").setPositiveButton("close", null).show();
        }

    }

}
