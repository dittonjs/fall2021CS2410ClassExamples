package com.usu.todosmvvm.viewmodels;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.usu.todosmvvm.database.AppDatabase;
import com.usu.todosmvvm.models.Todo;

public class TodosViewModel extends AndroidViewModel {
    private int i = 0;

    private AppDatabase db;
    private Handler handler;
    private ObservableArrayList<Todo> todos = new ObservableArrayList<>();

    public TodosViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "todosdb").build();
        handler = new Handler();
    }


    public ObservableArrayList<Todo> getTodos() {
        return todos;
    }

    public void markTodoCommand(Todo todo, boolean isComplete) {

    }

    public void updateTodoCommand(Todo todo, String newContent) {

    }

    public void removeTodoCommand(Todo todo) {

    }

    public void createTodoCommand(String contents) {
        new Thread(() -> {
            Todo newTodo = new Todo();
            newTodo.contents = contents;
            newTodo.id = db.getTodosDao().create(newTodo);
            // TODO add to database
            handler.post(() -> {
                todos.add(newTodo);
            });
        }).start();
    }
}
