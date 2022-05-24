package com.example.checklist.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.Manifest;
import android.app.Activity;
import android.graphics.Point;
import android.icu.text.DateTimePatternGenerator;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.checklist.R;
import com.example.checklist.fragment.CalendarFragment;
import com.example.checklist.fragment.HomeFragment;
import com.example.checklist.fragment.SetFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallbackWithBeforeParam;
import com.permissionx.guolindev.callback.ForwardToSettingsCallback;
import com.permissionx.guolindev.callback.RequestCallback;
import com.permissionx.guolindev.request.ExplainScope;
import com.permissionx.guolindev.request.ForwardScope;

import java.lang.reflect.Field;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

public class NavigationPager extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment fg1,fg2,fg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_pager);

        //app权限申请
        AppGetPermission();


        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.sidebar);


        //设置侧边栏全屏打开
        DrawerLayoutHelper.setDrawerLeftEdgeFullScreen(this,drawerLayout);
        navigationView.setNavigationItemSelectedListener((MenuItem item) -> {
            drawerLayout.closeDrawers();
            return true;
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        fg1 = new HomeFragment();
        replaceFragment(fg1);
        bottomNavigationView.setOnNavigationItemSelectedListener((MenuItem item)  -> {
            switch (item.getItemId()){
                case R.id.home:
                    if(fg1 == null){
                        fg1 = new HomeFragment();
                    }
                    replaceFragment(fg1);
                    break;
                case R.id.calendar:
                    if(fg2 == null){
                        fg2 = new CalendarFragment();
                    }
                    replaceFragment(fg2);
                    break;
                case R.id.set:
                    if(fg3 == null){
                        fg3 = new SetFragment();
                    }
                    replaceFragment(fg3);
                    break;
                default:break;
            }
            return true;
        });
    }


    /*权限申请*/
    private void AppGetPermission() {
        String[] permissions = new String[]{Manifest.permission.CAMERA,
                Manifest.permission.READ_CALENDAR,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.
                ACCESS_FINE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_SMS};
        PermissionX.init(this)
                .permissions(permissions)
                .onExplainRequestReason(new ExplainReasonCallbackWithBeforeParam() {
                    @Override
                    public void onExplainReason(@NonNull ExplainScope scope, @NonNull List<String> deniedList, boolean beforeRequest) {
                        scope.showRequestReasonDialog(deniedList,"即将申请的权限是程序必须依赖的权限","我已明白");
                    }
                })
                .onForwardToSettings(new ForwardToSettingsCallback() {
                    @Override
                    public void onForwardToSettings(@NonNull ForwardScope scope, @NonNull List<String> deniedList) {
                        scope.showForwardToSettingsDialog(deniedList,"您需要去应用程序设置当中手动开启权限","我已明白");
                    }
                })
                .request(new RequestCallback() {
                    @Override
                    public void onResult(boolean allGranted, @NonNull List<String> grantedList, @NonNull List<String> deniedList) {
                        if(allGranted)
                            Toast.makeText(NavigationPager.this, "所有权限已获取", Toast.LENGTH_LONG)
                                    .show();
                        else
                            Toast.makeText(NavigationPager.this, "您拒绝了如下权限：" + deniedList, Toast.LENGTH_SHORT)
                                    .show();
                    }
                });
    }
    /*替换页面fragment*/
    private void replaceFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.settings:
                Toast.makeText(this, "你点击了更多设置", Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
        return true;
    }
    //设置侧边栏的拉出方式
    static class DrawerLayoutHelper{
        public static void setDrawerLeftEdgeSize(Activity activity, DrawerLayout drawerLayout,
                                                 float displayWithPerecntage){
            if(activity == null || drawerLayout == null) return;
            try {
                Field leftDraggerfield = drawerLayout.getClass().getDeclaredField("mLeftDragger");
                leftDraggerfield.setAccessible(true);
                ViewDragHelper leftDragger = (ViewDragHelper)leftDraggerfield.get(drawerLayout);
                Field edgeSizeField = leftDragger.getClass().getDeclaredField("mEdgeSize");
                edgeSizeField.setAccessible(true);
                int edgeSize = edgeSizeField.getInt(leftDragger);

                Point displaySize = new Point();
                activity.getWindowManager().getDefaultDisplay().getSize(displaySize);
                edgeSizeField.setInt(leftDragger,(int)Math.max(edgeSize,(displaySize.x * displayWithPerecntage)));
                //获取 Layout 的 ViewDragCallBack 实例“mLeftCallback”
                //更改其属性 mPeekRunnable
                Field leftCallbackField = drawerLayout.getClass().getDeclaredField("mLeftCallback");
                leftCallbackField.setAccessible(true);
                //因为无法直接访问私有内部类，所以该私有内部类实现的接口非常重要，通过多态的方式获取实例
                ViewDragHelper.Callback leftCallback = (ViewDragHelper.Callback)leftCallbackField
                        .get(drawerLayout);
                Field peekRunnableField = leftCallback.getClass().getDeclaredField("mPeekRunnable");
                peekRunnableField.setAccessible(true);
                Runnable nullRunable = () -> {};
                peekRunnableField.set(leftCallback,nullRunable);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static void setDrawerLeftEdgeFullScreen(Activity activity,DrawerLayout drawerLayout){
            setDrawerLeftEdgeSize(activity,drawerLayout,0.5f);
        }
    }
}