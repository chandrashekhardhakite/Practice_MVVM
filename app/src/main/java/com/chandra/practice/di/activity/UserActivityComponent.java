package com.chandra.practice.di.activity;


import com.chandra.practice.adpater.UserRecyclerAdpater;
import com.chandra.practice.di.AppComponent;
import com.chandra.practice.ui.UserActivity;

import dagger.Component;
import dagger.Module;

@Component(modules = UserActivityModule.class)
@ActivityScope
public interface UserActivityComponent  {
//    UserRecyclerAdpater getUserRecyclerAdpater();

    void inject(UserActivity userActivity);
}
