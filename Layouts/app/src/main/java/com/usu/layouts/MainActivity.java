package com.usu.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // main layout
        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        LabelledInput userNameInput = new LabelledInput(this, "Username:");

        LabelledInput passwordInput = new LabelledInput(this, "Password:");

        // 0
        // login button
        AppCompatButton loginButton = new AppCompatButton(this);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        buttonParams.weight = 1;
        loginButton.setLayoutParams(buttonParams);
        loginButton.setText("Login");
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(userNameInput.getText());
            }
        });
        // 1
        // put everything together
        container.addView(userNameInput);
        container.addView(passwordInput);
        container.addView(loginButton);

        setContentView(container);
    }
}