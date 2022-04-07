package com.example.checklist.logic.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.datebase.Task;
import com.example.checklist.logic.datebase.User;

import java.util.List;

@Dao
public interface TaskDao {
    /*插入一个新日程*/
    @Insert
    public Long insertTask(Task task);
    /*更新日程*/
    @Update
    public void updateTask(Task newTask);
    /*读取表中所有日程信息*/
    @Query("select * from task")
    public List<User> loadAllTasks();
    /*获取某个时间段的日程*/
    @Query("select * from task where time > :startTime and time < :lastTime")
    public List<Task> loadTodayTasks(String startTime,String lastTime);
    /*删除id为xxx日程*/
    @Delete
    public void deleteUser(Task task,Long id);
}
