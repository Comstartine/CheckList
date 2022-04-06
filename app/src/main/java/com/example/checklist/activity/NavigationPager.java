package com.example.checklist.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


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



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigationView = findViewById(R.id.sidebar);
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
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
}