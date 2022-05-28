package com.example.checklist.logic.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Map;

@Entity(tableName = "remind")
public class Remind {

    @PrimaryKey(autoGenerate = true)
    private long remind_id = 0;     //提醒id
    private long remind_taskId;    //提醒日程
    private String remind_time;     //提醒具体时间
    private String remind_day;       //提醒日期时间

    public Remind(long remind_taskId, String remind_time, String remind_day) {
        this.remind_taskId = remind_taskId;
        this.remind_time = remind_time;
        this.remind_day = remind_day;
    }

    public long getRemind_id() {
        return remind_id;
    }

    public long getRemind_taskId() {
        return remind_taskId;
    }

    public void setRemind_taskId(long remind_taskId) {
        this.remind_taskId = remind_taskId;
    }

    public String getRemind_time() {
        return remind_time;
    }

    public void setRemind_time(String remind_time) {
        this.remind_time = remind_time;
    }

    public String getRemind_day() {
        return remind_day;
    }

    public void setRemind_day(String remind_day) {
        this.remind_day = remind_day;
    }

    @Override
    public String toString() {
        return "Remind{" +
                "remind_id=" + remind_id +
                ", remind_taskId=" + remind_taskId +
                ", remind_time='" + remind_time + '\'' +
                ", remind_day='" + remind_day + '\'' +
                '}';
    }
}
