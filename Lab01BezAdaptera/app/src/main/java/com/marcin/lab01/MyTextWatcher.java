package com.marcin.lab01;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by student on 26.05.18.
 */

public class MyTextWatcher implements TextWatcher {

    Context context;

    public MyTextWatcher (Context context) {
        this.context = context;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Activity activity;
        activity = (AppCompatActivity)context;
        EditText nameEditText = activity.findViewById(R.id.nameEditText);
        EditText surnameEditText = activity.findViewById(R.id.surnameEditText);
        EditText gradesEditText = activity.findViewById(R.id.gradesNumberEditText);

        boolean rangeGrades;

        try {
            rangeGrades = setRangeGrades(Integer.parseInt(gradesEditText.getText().toString()));
        }
        catch (NumberFormatException e) {
            rangeGrades = false;
        }


        Button button = activity.findViewById(R.id.gradeButton);

        if (!nameEditText.getText().toString().equals("") &&
                !surnameEditText.getText().toString().equals("") &&
                rangeGrades) {

            button.setVisibility(View.VISIBLE);
        }
        else {
            button.setVisibility(View.INVISIBLE);
        }
    }

    private boolean setRangeGrades (int grade) {

        if (grade >= 5 && grade <= 15) {
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
