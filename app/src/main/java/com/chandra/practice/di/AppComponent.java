package com.chandra.practice.di;

import com.chandra.practice.db.UserDao;
import com.chandra.practice.request.UserApiClient;

import dagger.Component;

@Component(
        modules = {AppModule.class}
)
@AppScope
public interface AppComponent {
    UserApiClient getUserApiClient();
    UserDao getUserDao();
}
