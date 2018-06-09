package com.example.jmach.lab1_cw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidGui1 extends AppCompatActivity {
    Toast errorName = Toast.makeText(this, "Imię nie może być puste!", Toast.LENGTH_SHORT);
    Toast errorSurname = Toast.makeText(this, "Nazwisko nie może być puste!", Toast.LENGTH_SHORT);
    Toast errorGrade = Toast.makeText(this, "Liczba ocen nie może być puste!", Toast.LENGTH_SHORT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Name = findViewById(R.id.textName);
        Name.setText(R.string.imie);

        TextView Surname = findViewById(R.id.textSurname);
        Surname.setText(R.string.nazwisko);

        TextView Grade = findViewById(R.id.textGrade);
        Grade.setText(R.string.liczba_ocen);

        EditText Name2 = findViewById(R.id.inputName);
        Name2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //s.toString() != "";
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
