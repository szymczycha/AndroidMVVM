package com.example.roommvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.roommvvm.database.UserDatabase;
import com.example.roommvvm.databinding.ActivityMainBinding;
import com.example.roommvvm.model.User;

public class MainActivity extends AppCompatActivity {
    private UserDatabase userDatabase;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
//        setContentView(R.layout.activity_main);
        userDatabase = UserDatabase.getInstance(MainActivity.this);
        binding.add1.setOnClickListener(v->{
            User user = new User("a", "b");
            userDatabase.userDAO().insertOne(user);
            int count = userDatabase.userDAO().getAll().size();
            binding.label.setText("Ilość rekordów: " + count);
        });
        binding.add3.setOnClickListener(v->{
            User user = new User("a", "b");
            userDatabase.userDAO().insertAll(user, user, user);
            int count = userDatabase.userDAO().getAll().size();
            binding.label.setText("Ilość rekordów: " + count);
        });
        binding.delete.setOnClickListener(v->{
            userDatabase.userDAO().deleteAll();
            int count = userDatabase.userDAO().getAll().size();
            binding.label.setText("Ilość rekordów: " + count);
        });
    }
}