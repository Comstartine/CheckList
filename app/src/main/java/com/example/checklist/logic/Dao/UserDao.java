package com.example.checklist.logic.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.datebase.User;

import java.util.List;

@Dao
public interface UserDao {
    /*插入一个新对象*/
    @Insert
    public Long insertUser(User user);
    /*更新对象*/
    @Update
    public void updateUser(User newUser);
    /*读取表中所有用户信息*/
    @Query("select * from user")
    public List<User> loadAllUsers();
    /*删除id为xxx对象*/
    @Delete
    public void deleteUser(User user);


}
