package com.chandra.practice.di;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.chandra.practice.UserApplication;
import com.chandra.practice.db.UserDao;
import com.chandra.practice.db.UserDataBase;
import com.chandra.practice.model.User;
import com.chandra.practice.request.UserApi;
import com.chandra.practice.request.UserApiClient;
import com.chandra.practice.utility.Constants;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private static final String TAG = "AppModule";
    private UserApplication mApplication;

   public AppModule(UserApplication application){
        if(application!=null)
            Log.d(TAG, "AppModule: ");
        this.mApplication = application;
    }

   @Provides
   @AppScope
    UserApi provideUserApi(){
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofitInstance = retrofitBuilder.build();
        return retrofitInstance.create(UserApi.class);
    }

    @Provides
    @AppScope
    UserApiClient proviodesUserApiClient(UserApi userApi){
        return new UserApiClient(userApi);
    }

    @Provides
    @AppScope
    UserDao provideUserDao(){
        Log.d(TAG, "provideUserDao: ");
       UserDataBase userDataBase =  Room.databaseBuilder(mApplication.getApplicationContext(), UserDataBase.class, "User")
                .fallbackToDestructiveMigration()
                .build();
       return userDataBase.userDao();
    }

}
