package com.usu.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // main layout
        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        // userName
        LinearLayout userNameLayout = new LinearLayout(this);
        AppCompatTextView userNameLabel = new AppCompatTextView(this);
        userNameLabel.setText("Username:");
        AppCompatEditText userNameField = new AppCompatEditText(this);
//        userNameField.setLayoutParams(userNameParams);
        userNameLayout.addView(userNameLabel);
        userNameLayout.addView(userNameField);
        LinearLayout.LayoutParams userNameParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        userNameParams.weight = 1;
        userNameLayout.setLayoutParams(userNameParams);
        //      0

        // password
        LinearLayout passwordLayout = new LinearLayout(this);
        AppCompatTextView passwordLabel = new AppCompatTextView(this);
        passwordLabel.setText("Password:");
        AppCompatEditText passwordField = new AppCompatEditText(this);
        passwordLayout.addView(passwordLabel);
        passwordLayout.addView(passwordField);
        // 0
        // login button
        AppCompatButton loginButton = new AppCompatButton(this);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonParams.weight = 1;
        loginButton.setLayoutParams(buttonParams);
        loginButton.setText("Login");
        // 1
        // put everything together
        container.addView(userNameLayout);
        container.addView(loginButton);
        container.addView(passwordLayout);

        setContentView(container);
    }
}