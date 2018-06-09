package com.example.jmach.cw1;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyFocusChangeListener implements View.OnFocusChangeListener {

    EditText editText;

    public MyFocusChangeListener(EditText editText) {
        this.editText = editText;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (!b) {
            String text;
            if (editText.getText().toString().equals("")) {
                if (editText.getId() == R.id.inputName) {
                    text = "Wpisz imię!";
                } else if (editText.getId() == R.id.inputSurname) {
                    text = "Wpisz nazwisko!";
                } else {
                    text = "Wpisz liczbę ocen!";
                }
                Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
            } else if (editText.getId() == R.id.inputGrade && (Integer.parseInt(editText.getText().toString()) < 5 || Integer.parseInt(editText.getText().toString()) > 15)) {
                text = "Liczba ocen: 5 - 15";
                Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
