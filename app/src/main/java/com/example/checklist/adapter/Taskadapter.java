package com.example.checklist.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.example.checklist.Customize.Tasks;
import com.example.checklist.R;

import java.util.List;

public class Taskadapter extends CommonRecyclerAdapter<Tasks>{

    public Taskadapter(Context context, List<Tasks> list, int itemLayoutId) {
        super(context, list, itemLayoutId);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Tasks item, int position) {
        String time = "test";
        String name = "TEST";
        String label = "test";
        holder.setText(R.id.task, TextUtils.isEmpty(name) ? "null": name);
        holder.setText(R.id.task_lasttime,TextUtils.isEmpty(time) ? "null": time);
        holder.setText(R.id.tasklabel,TextUtils.isEmpty(label) ? "null": label);
    }


}
