package com.chandra.practice.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.chandra.practice.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void insertUser(User user);

    @Update
    public void updateUser(User user);

    @Delete
    public void deleteUser(User user);

    @Query("DELETE FROM User")
    public void deleteAll();

    @Query("SELECT * FROM User")
    public LiveData<List<User>> getAllUser();


}
