package com.example.checklist.logic.Dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.ListTask;
import com.example.checklist.logic.entity.Lists;

import java.util.List;

@Dao
public interface ListsDao {

    @Insert
    void insertLists(Lists... lists);

    @Update
    int updateLists(Lists... lists);

    @Delete
    void deleteLists(Lists... lists);

    @Query("select * from lists")
    List<Lists> getLists();

    @Query("select * from lists where list_id = :ListId limit 1")   //通过清单Id获取
    Lists getList(Long ListId);

    @Query("select * from lists where list_icon = :ListIcon")   //通过清单头像获取
    List<Lists> getLists_Icon(String ListIcon);

    @Query("select * from lists where list_tasks_id = :ListTaskId") //通过清单日程Id获取
    List<Lists> getLists_TaskId(Long ListTaskId);

    @Query("select * from lists where list_name = :ListName")   //通过清单名头像获取
    List<Lists> getLists_Name(String ListName);

}

