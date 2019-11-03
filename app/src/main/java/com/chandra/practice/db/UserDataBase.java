package com.chandra.practice.db;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.chandra.practice.model.User;
import com.chandra.practice.request.UserApiClient;

import java.util.List;

@Database(entities = User.class, exportSchema = false, version = 1)
public abstract class UserDataBase extends RoomDatabase {
   public  abstract UserDao userDao();

    public static UserDataBase userDataBase;

    public synchronized static UserDataBase getUserDataBase(Application application) {
        if (userDataBase == null) {
            userDataBase = Room.databaseBuilder(application.getApplicationContext(), UserDataBase.class, "User")
//                    .addCallback(callback)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return userDataBase;
    }

    public static RoomDatabase.Callback callback = new Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InsertAsync(userDataBase.userDao()).execute();

        }

    };




}
