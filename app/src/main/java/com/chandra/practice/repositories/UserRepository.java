package com.chandra.practice.repositories;

import androidx.lifecycle.LiveData;

import com.chandra.practice.model.User;
import com.chandra.practice.request.UserApiClient;

import java.util.List;

public class UserRepository {

    private static final String TAG = "UserRepository";
    private UserApiClient userApiClient;

    public UserRepository() {

        userApiClient = UserApiClient.getuserApiClient();
    }

    public LiveData<List<User>> getUserlist(){
        return userApiClient.getUserList();
    }
}
