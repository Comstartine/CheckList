package com.example.checklist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.checklist.Customize.RoundButton;
import com.example.checklist.R;
import com.jem.liquidswipe.LiquidSwipeViewPager;
import com.jem.liquidswipe.base.LiquidSwipeLayout;
import com.jem.liquidswipe.clippathprovider.LiquidSwipeClipPathProvider;
import com.jem.liquidswipe.layout.LiquidSwipeConstraintLayout;
import com.jem.liquidswipe.layout.LiquidSwipeLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter{

    private ArrayList<LiquidSwipeClipPathProvider> liquidSwipeClipPathProviders;
    private ArrayList<View> viewLists;
    private Context context;


    public MyPagerAdapter(ArrayList<View> viewLists,ArrayList<LiquidSwipeClipPathProvider> providers) {
        super();
        this.viewLists = viewLists;
        liquidSwipeClipPathProviders = providers;
    }

    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LiquidSwipeConstraintLayout layout =(LiquidSwipeConstraintLayout) viewLists.get(position);
        layout.setClipPathProvider(liquidSwipeClipPathProviders.get(position));
        container.addView(viewLists.get(position));
        return viewLists.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewLists.get(position));
    }
}
