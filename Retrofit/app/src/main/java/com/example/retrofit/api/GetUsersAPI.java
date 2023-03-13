package com.example.retrofit.api;

import com.example.retrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetUsersAPI {
    @GET("/users")
    Call<List<User>> getAllUsers();
}
