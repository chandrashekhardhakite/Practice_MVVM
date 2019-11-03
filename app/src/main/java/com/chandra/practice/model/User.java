package com.chandra.practice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {


    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("type")
    @Expose
    private String type;


    public User(String login, Integer id, String avatarUrl, String type) {
        this.login = login;
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public Integer getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getType() {
        return type;
    }


}
