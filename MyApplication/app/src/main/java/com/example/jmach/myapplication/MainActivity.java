package com.example.jmach.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button B1;
        B1 = findViewById(R.id.button);
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               TextView T = findViewById(R.id.etykieta);
               T.setText(R.string.hello2);
            }
        });
    }
}
