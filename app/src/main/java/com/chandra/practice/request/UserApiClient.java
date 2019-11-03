package com.chandra.practice.request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.chandra.practice.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserApiClient {

    private static final String TAG = "UserApiClient";
    private static UserApiClient userApiClient;


    public UserApiClient() {
        ServiceGenrator.getServiceGenrator();
    }

    public static synchronized UserApiClient getuserApiClient() {

        if (userApiClient == null) {
            userApiClient = new UserApiClient();
        }
        return userApiClient;
    }

    public LiveData<List<User>> getUserList(){

         final MutableLiveData<List<User>> userlist = new MutableLiveData<>();
         ServiceGenrator.getUserApi().getUsers().enqueue(new Callback<List<User>>() {
             @Override
             public void onResponse(Call<List<User>> users, Response<List<User>> response) {
                 Log.d(TAG, "onResponse: "+response.body());
                 userlist.setValue(response.body());
             }

             @Override
             public void onFailure(Call<List<User>> call, Throwable t) {
                 Log.d(TAG, "onFailure: "+t.getMessage());

             }
         });

         return userlist;

    }
}
