package com.usu.todosmvvm;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;

import com.usu.todosmvvm.databinding.TodoListItemBinding;
import com.usu.todosmvvm.models.Todo;
import com.usu.todosmvvm.viewmodels.TodosViewModel;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.ViewHolder> {
    private ObservableArrayList<Todo> todos;
    private TodosViewModel viewModel;
    private OnEditClicked listener;

    public interface OnEditClicked {
        void onEditClicked(Todo todo);
    }

    public TodosAdapter(TodosViewModel viewModel, OnEditClicked listener) {
        this.todos = viewModel.getTodos();
        this.listener = listener;
        this.viewModel = viewModel;
        this.todos.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<Todo>>() {
            @Override
            public void onChanged(ObservableList<Todo> sender) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<Todo> sender, int positionStart, int itemCount) {
               notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList<Todo> sender, int positionStart, int itemCount) {
                notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList<Todo> sender, int fromPosition, int toPosition, int itemCount) {
                notifyItemMoved(fromPosition, toPosition);
            }

            @Override
            public void onItemRangeRemoved(ObservableList<Todo> sender, int positionStart, int itemCount) {
                notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TodoListItemBinding binding = TodoListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.binding.todo.setText(todo.contents);
        System.out.println(todo.isDone);
        if (todo.isDone) {
            holder.binding.todo.setTextColor(Color.RED);
        } else {
            holder.binding.todo.setTextColor(Color.BLACK);
        }
        holder.binding.todo.setChecked(todo.isDone);
        holder.binding.todo.setOnClickListener(view -> {
            System.out.println("asdfasdfasdfasdfasdf");

            viewModel.markTodoCommand(todo, !todo.isDone);
        });
        holder.binding.edit.setOnClickListener((view) -> {
            listener.onEditClicked(todo);
        });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TodoListItemBinding binding;
        public ViewHolder(@NonNull TodoListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
