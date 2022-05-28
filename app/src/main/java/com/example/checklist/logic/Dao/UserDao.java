package com.example.checklist.logic.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert //创建用户账号（注册）
    void insertUser(User... user);

    @Delete //注销用户账号
    void deleteUser(User... user);

    @Update     //根据用户修改用户信息
    int updateUser(User... user);

    @Query("select * from user where user_id = :userId")    //登入验证用户密码
    User getUser(Long userId);

    @Query("select * from user") //查询用户（管理员权限）
    List<User> getUsers();


}
