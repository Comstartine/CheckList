package com.example.checklist.logic.Dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.Location;
import com.example.checklist.logic.entity.Remind;

import java.util.List;

@Dao
public interface LocationDao {

    @Insert
    void insertLocation(Location... location);

    @Update
    int updateLocation(Location... location);

    @Delete
    void deleteLocation(Location... location);

    @Query("select * from location")//所有日程的定位信息
    List<Location> getLocations();

    @Query("select * from location where location_id = :LocationId")//通过id获取定位信息
    Location getLocationId(Long LocationId);

    @Query("select * from location where location_taskId = :LocationTaskId")//通过日程id获取定位信息
    List<Location> getLocationTaskId(Long LocationTaskId);

}
