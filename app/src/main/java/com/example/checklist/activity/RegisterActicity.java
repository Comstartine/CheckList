package com.example.checklist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.checklist.Customize.RoundButton;
import com.example.checklist.R;

public class RegisterActicity extends AppCompatActivity {


    private EditText et_user,et_OnePassword,et_TwoPassword;
    private RoundButton register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initEvent();
        setTitle("注册");
        setUpToolBar();
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener((View v) ->{
            onBackPressed();
        });
    }

    private void initEvent() {
    }

    private void initView() {
        et_user = findViewById(R.id.re_phoneNumber);
        et_OnePassword = findViewById(R.id.re_password_one);
        et_TwoPassword = findViewById(R.id.re_password_two);
        register = findViewById(R.id.re_register);
    }

}