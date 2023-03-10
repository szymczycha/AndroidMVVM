package com.example.retrofit.api;

import com.example.retrofit.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostAPI {
    @GET("/posts")
    Call<List<Post>> getAllPosts();

}
