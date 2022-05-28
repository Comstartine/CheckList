package com.example.checklist.logic.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.checklist.logic.entity.Files;
import com.example.checklist.logic.entity.UserList;

import java.util.List;

@Dao
public interface UserListDao {

    @Insert
    void insertUserList(UserList... userList);

    @Update
    int updateUserList(UserList... userList);

    @Delete
    void deleteUserList(UserList... userList);

    @Query("select * from user_list")
    List<UserList> getUserLists();

    @Query("select * from user_list where user_list_userId = :ul_UserId")
    List<UserList> getUserLists_UserId(Long ul_UserId);
}
