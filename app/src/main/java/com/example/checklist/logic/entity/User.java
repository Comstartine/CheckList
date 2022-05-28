package com.example.checklist.logic.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Map;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private long user_id = 0;   //用户id
    private String user_name;   //用户名
    private String user_phone;      //用户手机号
    private String user_address;    //用户所在地
    private String user_password;   //用户密码
    private String user_icon;       //用户头像

    public User(String user_phone, String user_address, String user_password) {
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_password = user_password;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }


    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }
}
