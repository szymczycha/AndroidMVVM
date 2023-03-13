package com.example.retrofit.api;

import com.example.retrofit.model.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CommentsAPI {
    @GET("/post/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);
}
