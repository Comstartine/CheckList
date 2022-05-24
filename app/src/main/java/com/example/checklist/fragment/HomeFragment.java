package com.example.checklist.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.checklist.R;
import com.example.checklist.adapter.Taskadapter;
import com.example.checklist.logic.datebase.Task;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RelativeLayout upcoming,notification,allmatters;
    private RecyclerView todaytask;
    private SwipeRefreshLayout refreshLayout;
    private Taskadapter taskadapter;
    private List<Task> ans;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        intifindviewById(view);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        ans = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            String time = String.valueOf(i*60);
            String name = "标签" + i;
            String text = "任务" + i;
            ans.add(new Task(time,name,text));
        }

        refreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        refreshLayout.setColorSchemeResources(R.color.design_default_color_primary);
        refreshLayout.setOnRefreshListener(() -> {
            refresh();
        });


        taskadapter = new Taskadapter(getContext(),ans,R.layout.item_todaytask);
        todaytask.setLayoutManager(new LinearLayoutManager(getContext()));
        todaytask.setAdapter(taskadapter);

//        taskadapter.setOnItemClickListener((RecyclerView parent,View v,int position) -> {
//            Toast.makeText(getContext(),"点击事件"+position,Toast.LENGTH_SHORT).show();
//        });
        return view;
    }

    private void intifindviewById(View view) {
        upcoming = view.findViewById(R.id.upComing);
        notification = view.findViewById(R.id.notification);
        allmatters = view.findViewById(R.id.allmatters);
        todaytask = view.findViewById(R.id.TodayTask);
    }

    private void refresh() {
        int n = ans.size();
        new Thread(() -> {
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            getActivity().runOnUiThread(() -> {
                for(int i = n ; i <= n + 2; i++){
                    String time = String.valueOf(i*60);
                    String name = "标签" + i;
                    String text = "任务" + i;
                    ans.add(new Task(time,name,text));
                }
                taskadapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            });
        }).start();
    }
}
