package com.usu.gridlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout borderLayout = new LinearLayout(this);
        borderLayout.setBackgroundColor(Color.GRAY);
        borderLayout.setOrientation(LinearLayout.VERTICAL);
        GridLayout gridLayout = new GridLayout(this);
        LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        gridLayout.setLayoutParams(gridParams);
//        gridLayout.setColumnCount(2);

        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {

                if (i == 1) {
                    if (j == 0) {
                        AppCompatTextView textView = new AppCompatTextView(this);
                        textView.setText("Text View " + i + j);
                        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                        params.rowSpec = GridLayout.spec(i, 1, 1);
                        params.columnSpec = GridLayout.spec(j, 2, 1);
                        textView.setLayoutParams(params);
                        textView.setGravity(Gravity.CENTER);
                        textView.setBackgroundColor(Color.WHITE);
                        gridLayout.addView(textView);
                    }

                } else {
                    AppCompatTextView textView = new AppCompatTextView(this);
                    textView.setText("Text View " + i + j);
                    GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                    params.rowSpec = GridLayout.spec(i, 1, 1);
                    params.columnSpec = GridLayout.spec(j, 1, 1);
                    params.setMargins(16,16,16,16);
                    textView.setLayoutParams(params);
                    textView.setGravity(Gravity.CENTER);
                    textView.setBackgroundColor(Color.WHITE);
                    gridLayout.addView(textView);
                }


            }

        }


        borderLayout.addView(gridLayout);
        setContentView(borderLayout);
    }
}