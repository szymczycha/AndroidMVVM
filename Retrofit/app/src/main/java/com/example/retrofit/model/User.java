package com.example.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class User {
    private int id;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public int getId() {
        return id;
    }

    @SerializedName("Body")
    private String text;

}
