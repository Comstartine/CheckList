package com.example.checklist;

import android.app.Application;
import android.content.Context;

/*
* 定义app全局变量
* */
public class CheckListApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        context = getApplicationContext();
        super.onCreate();
    }

    public static Context getContext(){
        return context;
    }

}
