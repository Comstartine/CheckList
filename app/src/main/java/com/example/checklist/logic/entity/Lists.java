package com.example.checklist.logic.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Map;

@Entity(tableName = "lists")
public class Lists {

    @PrimaryKey(autoGenerate = true)
    private long list_id = 0;   //清单id
    private String list_name;   //清单名
    private String list_icon;   //清单icon
    private Long list_tasks_id;    //清单所拥有的日程id

    public Lists(String list_name) {
        this.list_name = list_name;
    }

    public long getList_id() {
        return list_id;
    }

    public String getList_icon() {
        return list_icon;
    }

    public void setList_icon(String list_icon) {
        this.list_icon = list_icon;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public Long getList_tasks_id() {
        return list_tasks_id;
    }

    public void setList_tasks_id(Long list_tasks_id) {
        this.list_tasks_id = list_tasks_id;
    }

    @Override
    public String toString() {
        return "Lists{" +
                "list_id=" + list_id +
                ", list_name='" + list_name + '\'' +
                ", list_tasks_id=" + list_tasks_id +
                '}';
    }
}
