package com.usu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.usu.fragments.databinding.ActivityMainBinding;
import com.usu.fragments.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

//    buildFeatures {
//        viewBinding true
//    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("VIEW CREATED");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMainBinding binding = FragmentMainBinding.inflate(inflater, container, false);
        binding.button2.setOnClickListener(view -> {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container_view, SecondFragment.class, null)
                    .addToBackStack(null)
                    .commit();

        });
        System.out.println("CREATE VIEW");
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("FRAGMENT CREATED");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("FRAGMENT STARTED");
    }

    @Override
    public void onStop() {
        System.out.println("FRAGMENT STOPPED");

        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {

        System.out.println("FRAGMENT RESUMED");
        super.onResume();
    }
}
