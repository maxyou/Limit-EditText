package com.maxproj.limitedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int MAX_LENGTH = 10;
    EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_text = (EditText)findViewById(R.id.edit_text);
        edit_text.addTextChangedListener(new LimitTextWatcher(edit_text, MAX_LENGTH, new LimitTextWatcher.IF_callback() {
            @Override
            public void callback(int left) {
                if(left <= 0) {
                    Toast.makeText(MainActivity.this, "input is full", Toast.LENGTH_SHORT).show();
                }
            }
        }));

    }
}
