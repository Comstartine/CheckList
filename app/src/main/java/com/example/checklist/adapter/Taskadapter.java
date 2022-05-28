package com.example.checklist.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.example.checklist.R;
import com.example.checklist.logic.entity.Task;

import java.util.List;

public class Taskadapter extends CommonRecyclerAdapter<Task>{

    public Taskadapter(Context context, List<Task> list, int itemLayoutId) {
        super(context, list, itemLayoutId);
    }

    @Override
    public void convert(RecyclerViewHolder holder, Task item, int position) {
        String time = item.getTime();
        String name = item.getText();
        String label = item.getName();
        holder.setText(R.id.task, TextUtils.isEmpty(name) ? "null": name);
        holder.setText(R.id.task_lasttime,TextUtils.isEmpty(time) ? "null": time);
        holder.setText(R.id.tasklabel,TextUtils.isEmpty(label) ? "null": label);
    }


}
