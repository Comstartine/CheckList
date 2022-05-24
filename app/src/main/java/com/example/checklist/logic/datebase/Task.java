package com.example.checklist.logic.datebase;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity(tableName = "task")
public class Task {
    @PrimaryKey(autoGenerate = true)
    private long id = 0;
    private String time;
    private String name;
    private String text;
    private int categoryId;
    private boolean remind;

    public Task(String time,String name,String text){
        this.time = time;
        this.name = name;
        this.text = text;
    }

    public Task(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRemind() {
        return remind;
    }

    public void setRemind(boolean remind) {
        this.remind = remind;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", categoryId=" + categoryId +
                ", remind=" + remind +
                '}';
    }
}
