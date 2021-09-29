package com.usu.telephone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PhoneButtonData> buttonData = new ArrayList<PhoneButtonData>() {
        {
            add(new PhoneButtonData("1", 1, 0, 1));
            add(new PhoneButtonData("2", 1, 1, 1));
            add(new PhoneButtonData("3", 1, 2, 1));
            add(new PhoneButtonData("4", 2, 0, 1));
            add(new PhoneButtonData("5", 2, 1, 1));
            add(new PhoneButtonData("6", 2, 2, 1));
            add(new PhoneButtonData("7", 3, 0, 1));
            add(new PhoneButtonData("8", 3, 1, 1));
            add(new PhoneButtonData("9", 3, 2, 1));
            add(new PhoneButtonData("CLEAR", 4, 0, 1, PhoneButtonData.ButtonType.CLEAR));
            add(new PhoneButtonData("0", 4, 1, 1));
            add(new PhoneButtonData("CALL", 4, 2, 1, PhoneButtonData.ButtonType.CALL));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridLayout mainLayout = new GridLayout(this);

        PhoneNumberDisplay display = new PhoneNumberDisplay(this);
        mainLayout.addView(display);

        buttonData.forEach(data -> {
            PhoneButton button = new PhoneButton(this, data);
            button.setOnClickListener(view -> {
                if (data.buttonType == PhoneButtonData.ButtonType.NUMBER) {
                    display.setText(display.getText().toString() + data.text);
                } else if(data.buttonType == PhoneButtonData.ButtonType.CLEAR) {
                    display.setText("");
                } else {
                    Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                    phoneIntent.setData(Uri.parse("tel:" + display.getText().toString()));
                    startActivity(phoneIntent);
                }
            });
            mainLayout.addView(button);

        });


        setContentView(mainLayout);
    }
}