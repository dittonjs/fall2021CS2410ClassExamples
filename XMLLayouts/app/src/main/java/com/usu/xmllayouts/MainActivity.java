package com.usu.xmllayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.usu.xmllayouts.databinding.ActivityMainBinding;
import com.usu.xmllayouts.databinding.PaddedTextViewBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(view -> {
            System.out.println("asdfasdfasdf");
        });

        setContentView(binding.getRoot());


    }
}