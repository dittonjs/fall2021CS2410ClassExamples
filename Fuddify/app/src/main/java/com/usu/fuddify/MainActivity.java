package com.usu.fuddify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setBackgroundColor(Color.GRAY);

        AppCompatTextView myTextView = new AppCompatTextView(this);
        myTextView.setText("Enter text here...");
        container.addView(myTextView);

        final AppCompatEditText editText = new AppCompatEditText(this);

        AppCompatButton myButton = new AppCompatButton(this);
        myButton.setText("Fuddify");
        container.addView(editText);
        container.addView(myButton);
        AppCompatTextView fuddifiedTextView = new AppCompatTextView(this);
        container.addView(fuddifiedTextView);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myText = editText.getText().toString();
                String fuddifiedString = myText.replaceAll("r", "w").replaceAll("R", "W");
                fuddifiedTextView.setText(fuddifiedString);
                container.removeView(fuddifiedTextView);
//                setContentView(fuddifiedTextView);
            }

        });


        setContentView(container);

    }
}