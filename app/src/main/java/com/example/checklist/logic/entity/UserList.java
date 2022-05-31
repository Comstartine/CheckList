package com.example.checklist.logic.entity;


import androidx.room.Entity;

@Entity(tableName = "user_list",primaryKeys = {"user_list_listId","user_list_userId"})
public class UserList {

    private long user_list_listId = -1;  //清单id
    private long user_list_userId = -1;  //用户id

    public UserList(Long user_list_listId, Long user_list_userId) {
        this.user_list_listId = user_list_listId;
        this.user_list_userId = user_list_userId;
    }

    public Long getUser_list_listId() {
        return user_list_listId;
    }

    public void setUser_list_listId(Long user_list_listId) {
        this.user_list_listId = user_list_listId;
    }

    public Long getUser_list_userId() {
        return user_list_userId;
    }

    public void setUser_list_userId(Long user_list_userId) {
        this.user_list_userId = user_list_userId;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "user_list_listId=" + user_list_listId +
                ", user_list_userId=" + user_list_userId +
                '}';
    }
}
