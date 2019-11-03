package com.chandra.practice.request;

import com.chandra.practice.utility.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenrator {

//    private static UserApi userApi;
//    private static ServiceGenrator serviceGenrator;
//
//    private ServiceGenrator() {
//        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
//                .baseUrl(Constants.BASEURL)
//                .addConverterFactory(GsonConverterFactory.create());
//        Retrofit retrofitInstance = retrofitBuilder.build();
//        userApi = retrofitInstance.create(UserApi.class);
//
//    }
//
//    public synchronized static ServiceGenrator getServiceGenrator() {
//
//        if (serviceGenrator == null) {
//            serviceGenrator = new ServiceGenrator();
//        }
//        return serviceGenrator;
//    }
//
//    public static UserApi getUserApi() {
//        return userApi;
//    }
}
