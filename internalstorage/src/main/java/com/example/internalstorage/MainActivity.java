package com.example.internalstorage;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et);
        btnSave = (Button) findViewById(R.id.btnSave);

        readSavedText();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCurrentText();
            }
        });
    }

    private void readSavedText() {
        try {
            InputStream is = openFileInput("data");
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            is.close();

            String str = new String(bytes, "utf-8");
            et.setText(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCurrentText() {
        try {
            OutputStream os = openFileOutput("data", Context.MODE_PRIVATE);
            os.write(et.getText().toString().getBytes("utf-8"));
            os.flush();
            os.close();

            Toast.makeText(this, "save succeed", Toast.LENGTH_SHORT).show();
            return;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "save failed", Toast.LENGTH_SHORT).show();

    }

}
