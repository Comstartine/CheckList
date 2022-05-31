package com.example.checklist.Customize;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenUtils {

    public static int height;
    public static int width;
    private static ScreenUtils instance;
    private Context context;

    private ScreenUtils(Context context) {
        this.context = context;
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;
    }

    public static ScreenUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (ScreenUtils.class) {
                if(instance == null)
                instance = new ScreenUtils(context);
            }
        }
        return instance;
    }


    /**
     * 得到手机屏幕的宽度, pix单位
     */
    public static int getScreenWidth() {
        return width;
    }

    //获取屏幕的宽度
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }

    /**
     * 得到手机屏幕的高度, pix单位
     */
    public static int getScreenHeight(){
        return height;
    }
    //获取屏幕的高度
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }
    //px转dp
    public static int dp2px(Context context,float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density + 0.5f);
    }
}
