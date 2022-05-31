package com.example.checklist.logic.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "status")
public class Status {

    @PrimaryKey(autoGenerate = true)
    private long status_id = 0;     //状态id
    private String status_reTimes;  //状态重复时间
    private boolean status_isFinish;    //状态完成情况
    private String status_taskName;     //状态所属日程名
    private Long status_taskId;         //状态所属日程id

    public Status(String status_reTimes, boolean status_isFinish, String status_taskName) {
        this.status_reTimes = status_reTimes;
        this.status_isFinish = status_isFinish;
        this.status_taskName = status_taskName;
    }

    public void setStatus_id(long status_id) {
        this.status_id = status_id;
    }

    public long getStatus_id() {
        return status_id;
    }

    public String getStatus_reTimes() {
        return status_reTimes;
    }

    public void setStatus_reTimes(String status_reTimes) {
        this.status_reTimes = status_reTimes;
    }

    public boolean isStatus_isFinish() {
        return status_isFinish;
    }

    public void setStatus_isFinish(boolean status_isFinish) {
        this.status_isFinish = status_isFinish;
    }

    public String getStatus_taskName() {
        return status_taskName;
    }

    public void setStatus_taskName(String status_taskName) {
        this.status_taskName = status_taskName;
    }

    public Long getStatus_taskId() {
        return status_taskId;
    }

    public void setStatus_taskId(Long status_taskId) {
        this.status_taskId = status_taskId;
    }



    @Override
    public String toString() {
        return "Status{" +
                "status_id=" + status_id +
                ", status_reTimes='" + status_reTimes + '\'' +
                ", status_isFinish=" + status_isFinish +
                ", status_taskName='" + status_taskName + '\'' +
                ", status_taskId=" + status_taskId +
                '}';
    }
}
