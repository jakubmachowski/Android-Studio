package com.marcin.lab01;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by student on 26.05.18.
 */

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

                if (editText.getId() == R.id.nameEditText) {
                    text = "Wpisz Imię!";
                }
                else if (editText.getId() == R.id.surnameEditText) {
                    text = "Wpisz Nazwisko!";
                }
                else {
                    text = "Wpisz liczbę ocen!";
                }
                Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
            }
            else if (editText.getId() == R.id.gradesNumberEditText &&
                    (Integer.parseInt(editText.getText().toString()) < 5 ||
                    Integer.parseInt(editText.getText().toString()) > 15)) {

                text = "Błędna liczba ocen! (od 5 do 15)";
                Toast.makeText(view.getContext(), text, Toast.LENGTH_SHORT).show();
            }

        }
    }
}
