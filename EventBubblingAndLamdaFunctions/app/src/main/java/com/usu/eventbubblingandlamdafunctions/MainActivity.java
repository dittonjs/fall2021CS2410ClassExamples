package com.usu.eventbubblingandlamdafunctions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setBackgroundColor(Color.RED);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout secondLayout = new LinearLayout(this);
        secondLayout.setOrientation(LinearLayout.VERTICAL);
        secondLayout.setBackgroundColor(Color.CYAN);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        secondLayout.setLayoutParams(params);
        mainLayout.addView(secondLayout);.

        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("I AM THE MAIN LAYOUT");
            }
        });

        secondLayout.setOnClickListener(view -> {
            System.out.println("Hello, world!");
            AppCompatTextView textView = new AppCompatTextView(this);
            textView.setText("I AM A TEXT VIEW!!!!!");
            secondLayout.addView(textView);
        });



        AppCompatButton button = new AppCompatButton(this);
        button.setText("PRESS ME");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatTextView textView = new AppCompatTextView(MainActivity.this);
                textView.setText("I AM A TEXT VIEW!!!!!");
                secondLayout.addView(textView);
            }
        });

        secondLayout.addView(button);
        setContentView(mainLayout);

    }
}