package com.chandra.practice;

import android.app.Application;

import com.chandra.practice.db.UserDao;
import com.chandra.practice.di.AppComponent;
import com.chandra.practice.di.AppModule;
import com.chandra.practice.di.DaggerAppComponent;
import com.chandra.practice.request.UserApiClient;


public class UserApplication extends Application {
    private static final String TAG = "UserApplication";

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        UserApplication userApplication = (UserApplication) getApplicationContext();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(userApplication)).build();
    }

    public UserApiClient getUserApiClient() {
        return getmAppComponent().getUserApiClient();
    }

    public UserDao getUserDao() {
        return getmAppComponent().getUserDao();
    }

    public AppComponent getmAppComponent() {
        return mAppComponent;
    }
}
