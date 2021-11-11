package com.usu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.usu.fragments.databinding.AsdfThingMineBinding;
import com.usu.fragments.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSecondBinding binding = FragmentSecondBinding.inflate(inflater, container, false);
        binding.button3.setOnClickListener(view -> {

            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .
                    .add(R.id.fragment_container_view, MainFragment.class, null)
                    .addToBackStack(null)
                    .commit();
        });
        return binding.getRoot();
    }
}
