package com.example.app01.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.app01.R;
import com.example.app01.databinding.ActivityMainBinding;
import com.example.app01.viewmodel.SettingsViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private SettingsViewModel settingsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        settingsViewModel = new ViewModelProvider(MainActivity.this).get(SettingsViewModel.class);
        settingsViewModel.setupSettings();
        settingsViewModel.getObservedSettings().observe(MainActivity.this, s -> {
            activityMainBinding.label.setText(s.getUrl() + ":" + s.getPort());
        });
        activityMainBinding.button.setOnClickListener(v -> {
            settingsViewModel.changeSettings(activityMainBinding.url.getText().toString(), activityMainBinding.port.getText().toString());
        });

    }
}