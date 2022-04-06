package com.example.checklist.logic;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.checklist.logic.Dao.CategoryDao;
import com.example.checklist.logic.Dao.TaskDao;
import com.example.checklist.logic.Dao.UserDao;
import com.example.checklist.logic.datebase.Category;
import com.example.checklist.logic.datebase.RecommendTask;
import com.example.checklist.logic.datebase.Task;
import com.example.checklist.logic.datebase.User;

@Database(version = 1,entities = {Category.class, User.class, RecommendTask.class, Task.class})
abstract class AppDatabase extends RoomDatabase {
    public abstract CategoryDao CategoryDao();
    public abstract TaskDao TaskDao();
    public abstract UserDao UserDao();
}
