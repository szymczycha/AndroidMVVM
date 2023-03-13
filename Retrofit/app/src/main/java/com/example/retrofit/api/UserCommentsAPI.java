package com.example.retrofit.api;

import com.example.retrofit.model.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface UserCommentsAPI {
    @GET("/posts")
    Call<List<Post>> getUserPosts(
            @Query("userId") int userId,
            @Query("_sort") String sort,
            @Query("_order") String order
    );
    @GET("/posts")
    Call<List<Post>> getUserPostsMap(@QueryMap Map<String, String> params);
}
