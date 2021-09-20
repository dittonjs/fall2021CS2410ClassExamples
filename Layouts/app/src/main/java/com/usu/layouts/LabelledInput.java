package com.usu.layouts;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

public class LabelledInput extends LinearLayout {
    private AppCompatEditText field;
    public LabelledInput(Context context, String label) {
        super(context);
        AppCompatTextView labelTextView = new AppCompatTextView(context);
        labelTextView.setText(label);
        labelTextView.setTextSize(25);
        field = new AppCompatEditText(context);
        LinearLayout.LayoutParams fieldParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        field.setLayoutParams(fieldParams);

        setBackgroundColor(Color.CYAN);
        addView(labelTextView);
        addView(field);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(0, 0, 0, 100);
        setPadding(100, 100, 100, 100);

        setLayoutParams(layoutParams);
    }

    public String getText() {
        return field.getText().toString();
    }
}
