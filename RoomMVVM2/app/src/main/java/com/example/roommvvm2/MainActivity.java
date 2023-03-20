package com.example.roommvvm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.roommvvm2.adapters.NotesAdapter;
import com.example.roommvvm2.databinding.ActivityMainBinding;
import com.example.roommvvm2.viewmodel.NotesViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NotesViewModel notesViewModel;
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);

        binding.setNotesViewModel(notesViewModel);

        binding.gridview.setAdapter(adapter);

//        setContentView(R.layout.activity_main);
    }
}