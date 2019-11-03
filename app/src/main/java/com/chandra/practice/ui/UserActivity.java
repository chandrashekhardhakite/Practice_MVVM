package com.chandra.practice.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.chandra.practice.R;
import com.chandra.practice.adpater.UserRecyclerAdpater;
import com.chandra.practice.adpater.UserViewHolder;
import com.chandra.practice.model.User;
import com.chandra.practice.vm.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";

    private RecyclerView userRecyclerView;
    private List<User> userList;
    private UserViewModel userViewModel;
    private UserRecyclerAdpater userRecyclerAdpater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_mainactivity);
        userRecyclerView = findViewById(R.id.userRecycleView);
        userViewModel = ViewModelProviders.of(UserActivity.this).get(UserViewModel.class);
        setUserList();
        intiRecyclerView();

    }

    private void setUserList() {
        userViewModel.getuserlist().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {

                Log.d(TAG, "onChanged: "+users.size());
                userRecyclerAdpater.setUserList(users);
                userRecyclerAdpater.notifyDataSetChanged();
            }
        });


    }


    private void intiRecyclerView() {
        userRecyclerAdpater = new UserRecyclerAdpater(userList);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userRecyclerView.setAdapter(userRecyclerAdpater);
    }

}
