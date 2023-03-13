package com.example.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private int id;
    private int postId;
    private String name;
    private String email;
    @SerializedName("body")
    private String text;

    @Override
    public String toString() {
        return "\nComment{" +
                "\n    id=" + id +
                ",\n    postId=" + postId +
                ",\n    name='" + name + '\'' +
                ",\n    email='" + email + '\'' +
                "\n}";
    }
}
