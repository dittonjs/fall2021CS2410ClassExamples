package com.usu.telephone;

import android.content.Context;
import android.view.Gravity;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

public class PhoneNumberDisplay extends AppCompatTextView {

    public PhoneNumberDisplay(@NonNull Context context) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(0, 1, 1);
        params.columnSpec = GridLayout.spec(0, 3, 1);
        setGravity(Gravity.CENTER);
        setTextSize(40);
        setLayoutParams(params);
//        00001111
    //    00010010
    //    00011101

    }
}
