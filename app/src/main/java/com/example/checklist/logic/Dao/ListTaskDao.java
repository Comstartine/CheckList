package com.example.checklist.logic.Dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.ListTask;
import com.example.checklist.logic.entity.Location;

import java.util.List;

@Dao
public interface ListTaskDao {

    @Insert
    void insertListTask(ListTask... listTask);

    @Update
    int updateListTask(ListTask... listTask);

    @Delete
    void deleteListTask(ListTask... listTask);

    @Query("select * from list_task where list_task_listId = :lt_ListId")
    List<ListTask> getListTask_ListId(Long lt_ListId);

    @Query("select * from list_task where list_task_taskId = :lt_TaskId")
    List<ListTask> getListTask_TaskId(Long lt_TaskId);
}
