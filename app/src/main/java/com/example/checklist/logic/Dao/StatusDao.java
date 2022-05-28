package com.example.checklist.logic.Dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.Status;

import java.util.List;

@Dao
public interface StatusDao {

    @Insert
    void insertStatus(Status... status);

    @Update
    int updateStatus(Status... status);

    @Delete
    void deleteStatus(Status... status);

    @Query("select * from status")
    List<Status> getStatus();

    @Query("select * from status where status_id = :statusId ")//状态id查找
    Status getstatusId(long statusId);

    @Query("select * from status where status_taskName = :statusTaskName")//通过状态日程名查找
    List<Status> getStatusTaskName(String statusTaskName);

    @Query("select * from status where status_isFinish = :statusIsFinish")//通过状态日程是否完成查找
    List<Status> getStatusIsFinish(boolean statusIsFinish);

    @Query("select * from status where status_taskId = :statusTaskId")//通过状态日程id查找
    List<Status> getStatusTaskId(long statusTaskId);
}
