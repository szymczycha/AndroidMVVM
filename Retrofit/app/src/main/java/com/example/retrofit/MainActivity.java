package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.retrofit.api.CommentsAPI;
import com.example.retrofit.api.PostAPI;
import com.example.retrofit.api.UserCommentsAPI;
import com.example.retrofit.databinding.ActivityMainBinding;
import com.example.retrofit.model.Comment;
import com.example.retrofit.model.Post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
//        setContentView(R.layout.activity_main);
        activityMainBinding.get1.setOnClickListener( view1 -> {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            PostAPI postAPI = retrofit.create(PostAPI.class);
            Call<List<Post>> call = postAPI.getAllPosts();
            call.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    if(!response.isSuccessful()){
                        Log.d("XXX", String.valueOf(response.code()));
                        return;
                    }
                    else{
                        List<Post> posts = response.body();
                        Log.d("XXX", "onResponse: " + posts.size());
                        activityMainBinding.out.setText(posts.toString());
                    }
                }

                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {
                    Log.e("XXX", t.getMessage());
                }
            });
        });

        activityMainBinding.get2.setOnClickListener( view1 -> {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CommentsAPI postAPI = retrofit.create(CommentsAPI.class);
            Call<List<Comment>> call = postAPI.getComments(3);
            call.enqueue(new Callback<List<Comment>>() {
                @Override
                public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                    if(!response.isSuccessful()){
                        Log.d("XXX", String.valueOf(response.code()));
                        return;
                    }
                    else{
                        List<Comment> comments = response.body();
                        Log.d("XXX", "onResponse: " + comments.size());
                        activityMainBinding.out.setText(comments.toString());
                    }
                }

                @Override
                public void onFailure(Call<List<Comment>> call, Throwable t) {
                    Log.e("XXX", t.getMessage());
                }
            });
        });
        activityMainBinding.get3.setOnClickListener(v -> {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            UserCommentsAPI commentsAPI = retrofit.create(UserCommentsAPI.class);
            Call<List<Post>> call = commentsAPI.getUserPosts(3, "id", "desc");
            call.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    if(!response.isSuccessful()){
                        Log.e("XXX", String.valueOf(response.code()));
                        return;
                    }else{
                        Log.d("XXX", "onResponse: " + response.code());
                        List<Post> posts = response.body();
                        activityMainBinding.out.setText(posts.toString());
                    }
                }

                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {

                }
            });

        });
        activityMainBinding.get4.setOnClickListener(v -> {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            UserCommentsAPI commentsAPI = retrofit.create(UserCommentsAPI.class);
            Map<String,String> params = new HashMap<>();
            params.put("userId", "1");
            params.put("_sort", "id");
            params.put("_order", "desc");
            Call<List<Post>> call = commentsAPI.getUserPostsMap(params);
            call.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    if(!response.isSuccessful()){
                        Log.e("XXX", String.valueOf(response.code()));
                        return;
                    }
                    else{
                        Log.d("XXX", "onResponse: " + response.code());
                        List<Post> posts = response.body();
                        activityMainBinding.out.setText(posts.toString());
                    }
                }

                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {

                }
            });
        });
    }
}