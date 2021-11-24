package com.usu.todosmvvm.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.usu.todosmvvm.models.Todo;

@Database(entities = {Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodosDao getTodosDao();
}
