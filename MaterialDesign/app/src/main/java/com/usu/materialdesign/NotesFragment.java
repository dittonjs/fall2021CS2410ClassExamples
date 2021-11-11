package com.usu.materialdesign;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

public class NotesFragment extends Fragment {
    public NotesFragment() {
        super(R.layout.fragment_notes);
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        view.findViewById(R.id.floatingActionButton).setVisibility(View.INVISIBLE);
        view.findViewById(R.id.floatingActionButton).setOnClickListener((v) -> {
            System.out.println("DO I GET CALLED?!");
        });
//        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView2);

        recyclerView.setAdapter(new FakeDataAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        recyclerView2.setAdapter(new FakeDataAdapter());
//        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        super.onViewCreated(view, savedInstanceState);
    }
}