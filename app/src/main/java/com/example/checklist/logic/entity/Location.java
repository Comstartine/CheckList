package com.example.checklist.logic.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Map;

@Entity(tableName = "location")
public class Location {

    @PrimaryKey(autoGenerate = true)
    private long location_id = 0;   //定位id
    private String location_accurate;   //精准定位
    private String location_blurred;    //模糊定位
    private Long location_taskId;       //所属日程id

    public Location(String location_accurate, String location_blurred, Long location_taskId) {
        this.location_accurate = location_accurate;
        this.location_blurred = location_blurred;
        this.location_taskId = location_taskId;
    }

    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    public String getLocation_accurate() {
        return location_accurate;
    }

    public void setLocation_accurate(String location_accurate) {
        this.location_accurate = location_accurate;
    }

    public String getLocation_blurred() {
        return location_blurred;
    }

    public void setLocation_blurred(String location_blurred) {
        this.location_blurred = location_blurred;
    }

    public Long getLocation_taskId() {
        return location_taskId;
    }

    public void setLocation_taskId(Long location_taskId) {
        this.location_taskId = location_taskId;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + location_id +
                ", location_accurate='" + location_accurate + '\'' +
                ", location_blurred='" + location_blurred + '\'' +
                ", location_taskId=" + location_taskId +
                '}';
    }
}
