package com.example.checklist;

import android.app.Application;
import android.content.Context;

/*
* 定义app全局变量
* */
public class CheckListApplication extends Application {
    private static Context context;
    private static final String SERVER_ADDRESS = "120.78.13.17";

    @Override
    public void onCreate() {
        context = getApplicationContext();
        super.onCreate();
    }

    public static Context getContext(){
        return context;
    }
    public static String getServerAddress(){return SERVER_ADDRESS;}

}
