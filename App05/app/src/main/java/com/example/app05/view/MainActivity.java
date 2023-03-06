package com.example.app05.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.app05.R;
import com.example.app05.databinding.ActivityMainBinding;
import com.example.app05.viewmodel.ItemViewModel;

public class MainActivity extends AppCompatActivity {
    public ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        ItemViewModel itemViewModel = new ViewModelProvider(MainActivity.this)
                .get(ItemViewModel.class);
        itemViewModel.getMutableSelectedIndex().observe(MainActivity.this, s->{
            activityMainBinding.setItemViewModel(itemViewModel);
        });
        activityMainBinding.setItemViewModel(itemViewModel);
        activityMainBinding.addCategoryBtn.setOnClickListener(v->{
            itemViewModel.addCategory(activityMainBinding.entry.getText().toString());
        });
//        setContentView(R.layout.activity_main);
    }
}