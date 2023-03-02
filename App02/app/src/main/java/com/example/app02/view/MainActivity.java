package com.example.app02.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.app02.R;
import com.example.app02.databinding.ActivityMainBinding;
import com.example.app02.viewmodel.TestViewModel;
import com.example.app02.viewmodel.YearViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private TestViewModel testViewModel;
    private YearViewModel yearViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        testViewModel = new ViewModelProvider(MainActivity.this).get(TestViewModel.class);
        testViewModel.setupData(22);

        binding.setTestViewModel(testViewModel);
        testViewModel.getObservedAge().observe(MainActivity.this, s->{
            Log.d("XXX", "data changed");
            binding.setTestViewModel(testViewModel);
        });
        yearViewModel = new ViewModelProvider(MainActivity.this).get(YearViewModel.class);
        yearViewModel.setupData(2023);

        binding.setYearViewModel(yearViewModel);
        yearViewModel.getObservedYear().observe(MainActivity.this, s -> {
            Log.d("XXX", "year changed");
            binding.setYearViewModel(yearViewModel);
        });
    }
}