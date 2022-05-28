package com.example.checklist.logic.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.Task;
import com.example.checklist.logic.entity.User;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert         //添加日程
    void insertTask(Task... task);

    @Update         //更新日程
    int updateTask(Task... task);

    @Delete         //删除日程
    void deleteTask(Task... task);

    @Query("select * from task where task_Name like :TaskId")//日程id
    Task getTask_Id(long TaskId);

    @Query("select * from task where task_label = :TaskLabel")//日程标签
    List<Task> getTask_Label(String TaskLabel);

    @Query("select * from task where task_name = :TaskName")//日程名
    List<Task> getTask_Name(String TaskName);


    @Query("select * from task where task_address = :TaskAddress")//日程地址
    List<Task> getTask_Address(String TaskAddress);

    @Query("select * from task where task_priority = :TaskPriority")//日程优先级
    List<Task> getTask_Priority(String TaskPriority);

    @Query("select * from task where task_datetime = :TaskDatetime")//日程时间
    List<Task> getTask_Datetime(String TaskDatetime);



}
