package com.example.checklist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.checklist.R;

import io.alterac.blurkit.BlurLayout;

public class LoginPage extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        textView = findViewById(R.id.JumpOver);
        textView.setOnClickListener((View v) -> {
            startActivity(new Intent(this,NavigationPager.class));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}