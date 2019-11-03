package com.chandra.practice.adpater;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chandra.practice.R;
import com.chandra.practice.model.User;

import java.util.List;

public class UserRecyclerAdpater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "UserRecyclerAdpater";
    private List<User> userList;

    public UserRecyclerAdpater(List<User> userList) {
        this.userList = userList;
    }

    public void setUserList(List<User> list){
        userList = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(holder.itemView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(userList.get(position).getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(((UserViewHolder) holder).userAvtar);
        ((UserViewHolder) holder).name.setText(userList.get(position).getLogin());
        ((UserViewHolder) holder).id.setText(userList.get(position).getId().toString());
        ((UserViewHolder) holder).type.setText(userList.get(position).getType());


    }

    @Override
    public int getItemCount() {
        if(userList == null){
            return 0;
        }else {
            Log.d(TAG, "getItemCount: "+userList.size());
            return userList.size();
        }

    }
}
