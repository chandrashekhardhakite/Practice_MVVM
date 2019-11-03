package com.chandra.practice.repositories;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.chandra.practice.UserApplication;
import com.chandra.practice.db.InsertAsync;
import com.chandra.practice.db.UserDao;
import com.chandra.practice.db.UserDataBase;
import com.chandra.practice.model.User;
import com.chandra.practice.request.UserApiClient;

import java.util.List;

public class UserRepository {

    private static final String TAG = "UserRepository";
    private UserApiClient userApiClient;
    private UserDao userDao;
    private Context appContext;
    private MutableLiveData<Boolean> mIsQueryExhausted = new MutableLiveData<>();
    private MediatorLiveData<List<User>> mUsers = new MediatorLiveData<>();
    private MediatorLiveData<Boolean> isDownload = new MediatorLiveData<>();

    public boolean isDownloaded() {
        return downloaded;
    }

    private boolean downloaded = false;


    public UserRepository(UserApplication application) {
        this.appContext = application.getApplicationContext();
        userDao = application.getUserDao();
        userApiClient= application.getUserApiClient();
        initMediators();
    }

    private void initMediators() {

        LiveData<List<User>> recipeListApiSource = userApiClient.getUserList();
        mUsers.addSource(recipeListApiSource, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {

                if (users != null) {
                    mUsers.setValue(users);
                    inserData(users);
                } else {
                    // search database cache
                    inserData(null);
                }
            }
        });
    }

    public void inserData(List<User> users) {
        Log.d(TAG, "inserData: is called");
        new InsertAsync(userDao).execute(users);
    }


    public void setBoolean(boolean isDownload) {
        downloaded = isDownload;

    }


    public LiveData<List<User>> getUserlist() {
        return userDao.getAllUser();
    }

}
