package com.usu.todosmvvm.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    public String contents;

    @ColumnInfo(name = "is_done")
    public boolean isDone = false;
}
