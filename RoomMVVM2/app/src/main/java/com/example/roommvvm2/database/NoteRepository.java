package com.example.roommvvm2.database;

import com.example.roommvvm2.model.Note;

import java.util.List;

public class NoteRepository implements NoteDAO{
    private NoteDAO dao;

    public NoteRepository(NoteDAO dao) {
        this.dao = dao;
    }

    @Override
    public void insertOne(Note note) {
        dao.insertOne(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return dao.getAllNotes();
    }

    @Override
    public void deleteOne(Note note) {
        dao.deleteOne(note);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }
}
