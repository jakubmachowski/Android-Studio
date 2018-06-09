package com.example.jmach.cw1;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyTextWatcher implements TextWatcher {

    //Aktualny stan aplikacji.
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
        EditText nameEditText = activity.findViewById(R.id.inputName);
        EditText surnameEditText = activity.findViewById(R.id.inputSurname);
        EditText gradesEditText = activity.findViewById(R.id.inputGrade);

        //Deklaracja zmiennej logicznej do sprawdzenia przedziału liczby ocen.
        boolean rangeGrades;

        //Złapanie wyjątku jeśli liczba nie mieści się w: 5 - 15
        try {
            rangeGrades = setRangeGrades(Integer.parseInt(gradesEditText.getText().toString()));
        } catch (NumberFormatException e) {
            rangeGrades = false;
        }

        //Deklaracja przycisku z napisem "Oceny"
        Button buttonGrade = activity.findViewById(R.id.buttonGrade);

        //Jeśli wszystkie pola są poprawnie wypełnione to pokazuje się button "Oceny"
        if (!nameEditText.getText().toString().equals("") && !surnameEditText.getText().toString().equals("") && rangeGrades) {
            buttonGrade.setVisibility(View.VISIBLE);
        } else {
            buttonGrade.setVisibility(View.INVISIBLE);
        }
    }

    //Sprawdzenie czy liczba mieści się w: 5 - 15
    private boolean setRangeGrades (int numberGrade) {
        if (numberGrade >= 5 && numberGrade <= 15) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
