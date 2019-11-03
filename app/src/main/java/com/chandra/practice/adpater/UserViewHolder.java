package com.chandra.practice.adpater;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chandra.practice.R;

public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = "UserViewHolder";
    public ImageView userAvtar;
    public TextView id;
    public TextView name;
    public TextView type;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userAvtar = itemView.findViewById(R.id.userImageView);
        id = itemView.findViewById(R.id.userId);
        name = itemView.findViewById(R.id.userName);
        type = itemView.findViewById(R.id.userType);

    }

    @Override
    public void onClick(View view) {

    }
}
