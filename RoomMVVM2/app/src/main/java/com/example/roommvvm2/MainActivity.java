package com.example.roommvvm2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.roommvvm2.adapters.NotesAdapter;
import com.example.roommvvm2.databinding.ActivityMainBinding;
import com.example.roommvvm2.model.Note;
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

        adapter = new NotesAdapter(notesViewModel);

        binding.gridview.setAdapter(adapter);
        binding.deleteAllButton.setOnClickListener(view1 -> {
            notesViewModel.deleteAll();
        });
        notesViewModel.getObservedNotes().observe(MainActivity.this, notes->{
            binding.setNotesViewModel(notesViewModel);
            adapter.notifyDataSetChanged();
            Log.d("XXX", String.valueOf(notesViewModel.getObservedNotes().getValue()));
        });
        binding.addButton.setOnClickListener(v->{
            Note note = new Note("title", "content");
            notesViewModel.addNote(note);
        });
//        setContentView(R.layout.activity_main);
    }
}