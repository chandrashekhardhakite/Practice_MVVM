package com.chandra.practice.di.activity;

import com.chandra.practice.adpater.UserRecyclerAdpater;
import com.chandra.practice.model.User;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class UserActivityModule {
    private List<User> users;

    public UserActivityModule(List<User> users) {
        this.users = users;
    }

    @Provides
    @ActivityScope
    UserRecyclerAdpater providesUserRecyclerAdpater(){
        return new UserRecyclerAdpater(this.users);
    }

}
