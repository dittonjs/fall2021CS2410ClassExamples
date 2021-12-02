package com.usu.todosmvvm.viewmodels;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.usu.todosmvvm.database.AppDatabase;
import com.usu.todosmvvm.models.Todo;

import java.util.List;

public class TodosViewModel extends AndroidViewModel {
    private int i = 0;

    private AppDatabase db;
    private Handler handler;
    private ObservableArrayList<Todo> todos = new ObservableArrayList<>();
    private MutableLiveData<Todo> currentTodo = new MutableLiveData<>();
    private boolean loaded = false;

    public TodosViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "todosdb").build();
        handler = new Handler();
    }

    public void loadTodos() {
        if (!loaded) {
            loaded = true;
            new Thread(() -> {
                List<Todo> todoList = db.getTodosDao().getAll();
                handler.post(() -> {
                    todos.addAll(todoList);
                });
            }).start();
        }

    }
    public ObservableArrayList<Todo> getTodos() {
        return todos;
    }

    public void setCurrentTodo(Todo todo) {
        this.currentTodo.setValue(todo);
    }

    public MutableLiveData<Todo> getCurrentTodo() {
        return currentTodo;
    }

    public void markTodoCommand(Todo todo, boolean isDone) {
        new Thread(() -> {
            todo.isDone = isDone;
            db.getTodosDao().update(todo);
            int index = todos.indexOf(todo);
            handler.post(() -> {
                todos.set(index, todo);
            });
        }).start();

    }

    public void updateTodoCommand(Todo todo, String newContent) {
        new Thread(() -> {
            todo.contents = newContent;
            db.getTodosDao().update(todo);
            int index = todos.indexOf(todo);
            handler.post(() -> {
                todos.set(index, todo);
            });
        }).start();
    }

    public void removeTodoCommand(Todo todo) {

    }

    public void saveTodo(String contents) {
        new Thread(() -> {
            if (currentTodo.getValue() != null) {
                // updating
                currentTodo.getValue().contents = contents;
                db.getTodosDao().update(currentTodo.getValue());
                int index = todos.indexOf(currentTodo.getValue());
                handler.post(() -> {
                    todos.set(index, currentTodo.getValue());
                });
            } else {
                // create
                Todo newTodo = new Todo();
                newTodo.contents = contents;
                newTodo.id = db.getTodosDao().create(newTodo);
                // TODO add to database
                handler.post(() -> {
                    todos.add(newTodo);
                });
            }
        }).start();
    }
}
