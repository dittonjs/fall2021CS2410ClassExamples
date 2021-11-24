package com.usu.todosmvvm.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.usu.todosmvvm.models.Todo;

import java.util.List;

// CRUD
// Create
// Read
// Update
// Delete

@Dao
public interface TodosDao {
    @Insert
    public long create(Todo todo);

    @Query("SELECT * FROM todo")
    public List<Todo> getAll();

    @Query("SELECT * FROM todo WHERE id = :id")
    public Todo getOne(long id);

    @Update
    public void update(Todo todo);

    @Delete
    public void delete(Todo todo);
}
