package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.retrofit.api.CommentsAPI;
import com.example.retrofit.api.GetUsersAPI;
import com.example.retrofit.api.PostAPI;
import com.example.retrofit.api.UserCommentsAPI;
import com.example.retrofit.databinding.ActivityMainBinding;
import com.example.retrofit.model.Comment;
import com.example.retrofit.model.Post;
import com.example.retrofit.model.User;
import com.example.retrofit.viewmodel.SpinnerViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        String TAG = "XXX";
//        setContentView(R.layout.activity_main);
        SpinnerViewModel spinnerViewModel = new ViewModelProvider(MainActivity.this)
                .get(SpinnerViewModel.class);
        activityMainBinding.setSpinnerVM(spinnerViewModel);
        spinnerViewModel.getMutableUserIds().observe(MainActivity.this, s -> {
            //
        });
        Retrofit usersRetrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetUsersAPI usersAPI = usersRetrofit.create(GetUsersAPI.class);
        Call<List<User>> call1 = usersAPI.getAllUsers();
        call1.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    Log.e("XXX", String.valueOf(response.code()));
                    return;
                }else{
                    Log.d(TAG, "gotUsers: " + response.code());
                    List<User> users = response.body();
                    List<String> userIds = new ArrayList<>();
                    for (User user :
                            users) {
                        userIds.add(String.valueOf(user.getId()));
                    }
                    Log.d(TAG, userIds.toString());
                    spinnerViewModel.setUserIds(userIds);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("XXX", t.getMessage());
            }
        });
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