package com.usu.telephone;

import android.content.Context;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class PhoneButton extends AppCompatButton {
    // X.X.X

    //1.1.2

    public PhoneButton(@NonNull Context context, PhoneButtonData data) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(data.row, 1,1);
        params.columnSpec = GridLayout.spec(data.col, data.colSpan, 1);
        setText(data.text);
        setTextSize(24);
        setBackgroundColor(getResources().getColor(R.color.button_color, null));
        setLayoutParams(params);
    }
}
