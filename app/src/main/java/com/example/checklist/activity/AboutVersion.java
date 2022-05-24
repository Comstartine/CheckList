package com.example.checklist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.checklist.R;

public class AboutVersion extends AppCompatActivity {

     private TextView returnUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_version);
        returnUp = findViewById(R.id.returnUp);
        returnUp.setOnClickListener((View v) -> {
            finish();
        });
    }
}