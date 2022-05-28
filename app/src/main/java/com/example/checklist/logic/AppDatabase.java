package com.example.checklist.logic;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//import com.example.checklist.logic.Dao.TaskDao;
import com.example.checklist.logic.Dao.UserDao;
//import com.example.checklist.logic.datebase.RecommendTask;
import com.example.checklist.logic.entity.Files;
import com.example.checklist.logic.entity.Label;
import com.example.checklist.logic.entity.ListTask;
import com.example.checklist.logic.entity.Lists;
import com.example.checklist.logic.entity.Location;
import com.example.checklist.logic.entity.Remind;
import com.example.checklist.logic.entity.Status;
import com.example.checklist.logic.entity.Task;
import com.example.checklist.logic.entity.User;
import com.example.checklist.logic.entity.UserList;

@Database(entities = {User.class,UserList.class,Task.class, Status.class, Remind.class,
        Location.class, ListTask.class,Lists.class, Label.class, Files.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

        private static volatile AppDatabase instance;
        public AppDatabase getInstance(Context context){
            if(instance == null){
                synchronized (AppDatabase.class){
                    if(instance == null){
                        instance = Room.databaseBuilder(context.getApplicationContext(),
                                AppDatabase.class,"checklist.db")
                                .build();
                    }
                }
            }
            return instance;
        }
}
