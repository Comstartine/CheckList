package com.example.checklist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.checklist.Customize.RoundButton;
import com.example.checklist.R;
import com.example.checklist.adapter.MyPagerAdapter;
import com.jem.liquidswipe.LiquidSwipeViewPager;
import com.jem.liquidswipe.clippathprovider.LiquidSwipeClipPathProvider;
import com.jem.liquidswipe.layout.LiquidSwipeConstraintLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private LiquidSwipeViewPager viewPager;
    private ArrayList<View> lists;
    private MyPagerAdapter adapter;
    private ArrayList<LiquidSwipeClipPathProvider> liquidSwipeClipPathProviders;
    private RoundButton entrance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        liquidSwipeClipPathProviders = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            LiquidSwipeClipPathProvider liquidSwipeClipPathProvider = new LiquidSwipeClipPathProvider();
            liquidSwipeClipPathProviders.add(liquidSwipeClipPathProvider);
        }

        viewPager = findViewById(R.id.startPager);
        LayoutInflater inflater = getLayoutInflater();
        lists = new ArrayList<>(3);
        lists.add(inflater.inflate(R.layout.pagerone,null,false));
        lists.add(inflater.inflate(R.layout.pagertwo,null,false));
        lists.add(inflater.inflate(R.layout.pagerthree,null,false));
        adapter = new MyPagerAdapter(lists,liquidSwipeClipPathProviders);

        viewPager.setAdapter(adapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float waveCenterY = event.getY();
                for (int i = 0; i < 3; i++) {
                    liquidSwipeClipPathProviders.get(i).setWaveCenterY(waveCenterY);
                }
                return false;
            }
        });

        entrance = lists.get(2).findViewById(R.id.entrance);
        entrance.setOnClickListener((View v) -> {
            startActivity(new Intent(this,LoginPage.class));
        });


    }
}