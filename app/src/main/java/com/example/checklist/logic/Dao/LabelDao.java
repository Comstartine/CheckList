package com.example.checklist.logic.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.Label;
import com.example.checklist.logic.entity.Lists;

import java.util.List;

@Dao
public interface LabelDao {

    @Insert
    void insertLabel(Label... label);

    @Update
    int updateLabel(Label... label);

    @Delete
    void deleteLabel(Label... label);

    @Query("select * from label")
    List<Label> getLabels();

    @Query("select * from label where label_id = :LabelId") //标签id获取
    List<Label> getLabel_Id(Long LabelId);

    @Query("select * from label where label_color = :LabelColor")   //标签颜色
    List<Label> getLabel_Color(Long LabelColor);

    @Query("select * from label where label_name = :LabelName") //标签名
    List<Label> getLabel_Name(String LabelName);
}
