package com.usu.telephone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PhoneButtonData> buttonData = new ArrayList<PhoneButtonData>() {
        {
            add(new PhoneButtonData())
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int[] values = {1,2,3};

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        AppCompatEditText phoneNumberEditText = new AppCompatEditText(this);
        phoneNumberEditText.setInputType(InputType.TYPE_CLASS_PHONE);

        AppCompatButton callButton = new AppCompatButton(this);
        callButton.setOnClickListener(view -> {
            Intent phoneIntent = new Intent(Intent.ACTION_CALL);
            phoneIntent.setData(Uri.parse("tel:" + phoneNumberEditText.getText().toString()));
            startActivity(phoneIntent);
        });
        callButton.setText("CALL");

        mainLayout.addView(phoneNumberEditText);
        mainLayout.addView(callButton);

        setContentView(mainLayout);
    }
}