package com.example.checklist.logic.Dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.Remind;
import com.example.checklist.logic.entity.Status;

import java.util.List;

@Dao
public interface RemindDao {

    @Insert
    void insertRemind(Remind... remind);

    @Update
    int updateRemind(Remind... remind);

    @Delete
    void deleteRemind(Remind... remind);

    @Query("select * from remind")
    List<Remind> getRemind();

    @Query("select * from remind where remind_id = :remindId ")//状态id查找
    Status getRemindId(long remindId);

    @Query("select * from remind where remind_day = :remindDay")//通过状态日程名查找
    List<Status> getRemindDay(String remindDay);

    @Query("select * from remind where remind_time = :remindTime")//通过状态日程是否完成查找
    List<Status> getRemindTime(boolean remindTime);

    @Query("select * from remind where remind_taskId = :remindTaskId")//通过状态日程id查找
    List<Status> getRemindTaskId(long remindTaskId);
}
