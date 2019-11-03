package com.chandra.practice.request;

import android.app.Application;
import android.service.autofill.UserData;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.chandra.practice.db.InsertAsync;
import com.chandra.practice.db.UserDataBase;
import com.chandra.practice.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserApiClient {

    private static final String TAG = "UserApiClient";
    private static UserApiClient userApiClient;
    private List<User> list = new ArrayList<>();
    private Application application;
    private Boolean dataReceived = false;
    private MutableLiveData<Boolean> dataReceiveObserable = new MutableLiveData<>();


    public UserApiClient() {
        ServiceGenrator.getServiceGenrator();
    }

    public static synchronized UserApiClient getuserApiClient() {

        if (userApiClient == null) {
            userApiClient = new UserApiClient();
        }
        return userApiClient;
    }


    public LiveData<List<User>> getUserList() {

        final MutableLiveData<List<User>> userlist = new MutableLiveData<>();
        ServiceGenrator.getUserApi().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> users, Response<List<User>> response) {
                Log.d(TAG, "onResponse: " + response.body());
                list = response.body();
                userlist.setValue(response.body());
                dataReceived = true;
                dataReceiveObserable.setValue(dataReceived);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                userlist.postValue(null);
                dataReceiveObserable.setValue(false);

            }
        });
        return userlist;

    }

    public List<User> getUserListForDB() {
        Log.d(TAG, "getUserListForDB- : " + this.list.get(0).getLogin());
        return this.list;
    }

    public LiveData<Boolean> getDataReceiveFlag() {
        return dataReceiveObserable;

    }


}
