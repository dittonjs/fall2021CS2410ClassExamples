package com.usu.todosmvvm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.usu.todosmvvm.databinding.FragmentTodosBinding;
import com.usu.todosmvvm.models.Todo;
import com.usu.todosmvvm.viewmodels.TodosViewModel;

public class TodosFragment extends Fragment {
    public int callCount = 0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("I GOT CALLED");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTodosBinding binding = FragmentTodosBinding.inflate(inflater, container, false);

        TodosViewModel viewModel = new ViewModelProvider(requireActivity()).get(TodosViewModel.class);
        viewModel.loadTodos();
        binding.fab.setOnClickListener(view -> {
            viewModel.setCurrentTodo(null);
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainerView, EditTodoFragment.class, null)
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .commit();
        });

        System.out.println("am I getting called again? " + callCount++);
        binding.recyclerView.setAdapter(new TodosAdapter(viewModel, todo -> {
            viewModel.setCurrentTodo(todo);
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainerView, EditTodoFragment.class, null)
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .commit();
        }));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}