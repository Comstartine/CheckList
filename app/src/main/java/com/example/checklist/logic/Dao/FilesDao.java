package com.example.checklist.logic.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.Files;
import com.example.checklist.logic.entity.Label;

import java.util.List;

@Dao
public interface FilesDao {

    @Insert
    void insertFiles(Files... files);

    @Update
    int updateFiles(Files... files);

    @Delete
    void deleteFiles(Files... files);

    @Query("select * from files")
    List<Files> getFiles();

    @Query("select * from files where file_id = :FileId")  //文件ID
    Files getFile(Long FileId);

    @Query("select * from files where file_name = :FileName")   //文件名
    List<Files> getFiles_Name(String FileName);

    @Query("select * from files where file_taskId = :FileTaskId")   //文件日程id
    List<Files> getFiles_TaskId(Long FileTaskId);
}