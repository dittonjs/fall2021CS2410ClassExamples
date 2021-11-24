package com.usu.todosmvvm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.usu.todosmvvm.databinding.FragmentEditTodoBinding;
import com.usu.todosmvvm.viewmodels.TodosViewModel;

public class EditTodoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TodosViewModel viewModel = new ViewModelProvider(requireActivity()).get(TodosViewModel.class);


        FragmentEditTodoBinding binding = FragmentEditTodoBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment

        binding.getRoot().setOnClickListener(view -> {
            getActivity().getSupportFragmentManager().popBackStack();
        });

        binding.save.setOnClickListener(view -> {
            viewModel.createTodoCommand(binding.todo.getText().toString());
            getActivity().getSupportFragmentManager().popBackStack();
        });
        return binding.getRoot();
    }
}