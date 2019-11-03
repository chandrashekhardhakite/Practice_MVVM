package com.chandra.practice.request;

import androidx.lifecycle.LiveData;

import com.chandra.practice.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

    @GET("users")
    Call<List<User>> getUsers();

}
