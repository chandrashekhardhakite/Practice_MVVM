package com.chandra.practice.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.chandra.practice.model.User;
import com.chandra.practice.repositories.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }


    public LiveData<List<User>> getuserlist() {
        return userRepository.getUserlist();
    }


}
