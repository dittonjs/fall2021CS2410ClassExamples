package com.usu.countermvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int currentCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CounterViewModel viewModel = new ViewModelProvider(this).get(CounterViewModel.class);
        TextView counter = findViewById(R.id.counter);
        viewModel.getCount().observe(this, count -> {
            counter.setText("" + count);
        });

        findViewById(R.id.increment).setOnClickListener(view -> {
            viewModel.incrementCommand();
        });

        findViewById(R.id.decrement).setOnClickListener(view -> {
            viewModel.decrementCommand();
        });

        findViewById(R.id.timesTen).setOnClickListener(view -> {
            viewModel.timesTenCommand();
        });

        findViewById(R.id.half).setOnClickListener(view -> {
            viewModel.halfCommand();
        });


    }
}