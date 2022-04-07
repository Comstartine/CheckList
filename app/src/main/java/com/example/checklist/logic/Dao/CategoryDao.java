package com.example.checklist.logic.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.checklist.logic.datebase.Category;
import com.example.checklist.logic.datebase.User;

import java.util.List;

@Dao
public interface CategoryDao {
    /*插入一个新类别*/
    @Insert
    public Long insertCategory(Category category);
    /*读取表中所有类别信息*/
    @Query("select * from category")
    public List<Category> loadAllUsers();
    /*删除id为xxx分类*/
    @Delete
    public void deleteUser(Category category,Long id);
}
