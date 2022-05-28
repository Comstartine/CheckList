package com.example.checklist.logic.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "task")
public class Task {



    @PrimaryKey(autoGenerate = true)
    private long task_id = 0;   //自增长id
    private String task_datetime; //日程时间
    private String task_name;   //日程名
    private String task_priority;  //日程优先级
    private String task_record;     //日程重复次数
    private String task_label;         //日程标签
    private String task_address;        //日程所处地址

    //构造函数

    public Task(String task_name) {
        this.task_name = task_name;
    }

    public long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public String getTask_datetime() {
        return task_datetime;
    }

    public void setTask_datetime(String task_datetime) {
        this.task_datetime = task_datetime;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_priority() {
        return task_priority;
    }

    public void setTask_priority(String task_priority) {
        this.task_priority = task_priority;
    }

    public String getTask_record() {
        return task_record;
    }

    public void setTask_record(String task_record) {
        this.task_record = task_record;
    }

    public String getTask_label() {
        return task_label;
    }

    public void setTask_label(String task_label) {
        this.task_label = task_label;
    }

    public String getTask_address() {
        return task_address;
    }

    public void setTask_address(String task_address) {
        this.task_address = task_address;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_datetime='" + task_datetime + '\'' +
                ", task_name='" + task_name + '\'' +
                ", task_priority='" + task_priority + '\'' +
                ", task_record='" + task_record + '\'' +
                ", task_label='" + task_label + '\'' +
                ", task_address='" + task_address + '\'' +
                '}';
    }
}
