package com.example.roommvvm2.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roommvvm2.model.Note;

import java.util.List;

@Dao
public interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOne(Note note);

    @Query("SELECT * FROM notesTBL")
    List<Note> getAllNotes();

    @Delete
    void deleteOne(Note note);

    @Query("DELETE FROM notesTBL")
    void deleteAll();
}
