package com.example.myapplication;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;

public class validate {
    private Context context;

    public validate(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilled(EditText textInputEditText) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isInputEditTextEmail(EditText textInputEditText) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            return false;
        }
        return true;
    }
    public boolean isInputEditTextMatches(EditText textInputEditText1, EditText textInputEditText2) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (value1.contentEquals(value2)) {
            return false;
        }
        return true;
    }
}
