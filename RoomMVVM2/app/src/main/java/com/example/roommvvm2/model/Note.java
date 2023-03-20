package com.example.roommvvm2.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notesTBL")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "timestamp")
    private int timestamp;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        // timestamp do zrobienia z date?
    }
}
