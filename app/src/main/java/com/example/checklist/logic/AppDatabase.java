package com.example.checklist.logic;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.checklist.logic.Dao.CategoryDao;
import com.example.checklist.logic.Dao.RecommendTaskDao;
import com.example.checklist.logic.Dao.TaskDao;
import com.example.checklist.logic.Dao.UserDao;
import com.example.checklist.logic.datebase.Category;
import com.example.checklist.logic.datebase.RecommendTask;
import com.example.checklist.logic.datebase.Task;
import com.example.checklist.logic.datebase.User;

@Database(version = 1,entities = {Category.class, User.class, RecommendTask.class, Task.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract CategoryDao categoryDao();
    public abstract TaskDao taskDao();
    public abstract UserDao userDao();
    public abstract RecommendTaskDao recommendTaskDao();

    static class Companion{
        private AppDatabase instance;
        private Companion(){}
        public AppDatabase getInstance(Context context){
            if(instance == null){
                synchronized (AppDatabase.class){
                    if(instance == null){
                        instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"app_database")
                                .build();
                    }
                }
            }
            return instance;
        }
    }

}
