package com.chandra.practice.db;

import android.os.AsyncTask;
import android.util.Log;

import com.chandra.practice.model.User;

import java.util.List;

public  class InsertAsync extends AsyncTask<List<User>,Void,String> {
    private static final String TAG = "InsertAsync";

    private UserDao userDao;

    public InsertAsync(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(List<User>... lists) {
        Log.d(TAG, "doInBackground: "+lists[0].get(0).getLogin());
        if(lists!=null){
            for(User user: lists[0]) {
                Log.d(TAG, "doInBackground: "+user.getLogin());
                userDao.insertUser(user);
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
