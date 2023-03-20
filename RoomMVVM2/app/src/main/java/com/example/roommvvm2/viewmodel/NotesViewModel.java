package com.example.roommvvm2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.roommvvm2.database.NoteDatabase;
import com.example.roommvvm2.database.NoteRepository;
import com.example.roommvvm2.model.Note;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {
    public NotesViewModel(@NonNull Application application) {
        super(application);
        noteDatabase = NoteDatabase.getInstance(application.getApplicationContext());

        noteRepository = new NoteRepository(noteDatabase.noteDAO());

        this.mutableNotesList = new MutableLiveData<>();
        this.mutableNotesList.setValue(noteRepository.getAllNotes());

    }
    private MutableLiveData<List<Note>> mutableNotesList;

    private NoteRepository noteRepository;

    private NoteDatabase noteDatabase;

    public MutableLiveData<List<Note>> getObservedNotes() {
        return mutableNotesList;
    }
    public void addNote(Note note){
        noteRepository.insertOne(note);
        this.mutableNotesList.setValue(noteRepository.getAllNotes());
    }

}