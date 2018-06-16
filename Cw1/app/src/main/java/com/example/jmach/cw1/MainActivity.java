package com.example.jmach.cw1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Deklarowanie zmiennych pól wprowadzania tekstu.
        EditText editTextName = findViewById(R.id.inputName);
        EditText editTextSurname = findViewById(R.id.inputSurname);
        EditText editTextGrades = findViewById(R.id.inputGrade);

        //Odniesienie się do klasy MyFocusChangeListener.java
        editTextName.setOnFocusChangeListener(new MyFocusChangeListener(editTextName));
        editTextSurname.setOnFocusChangeListener(new MyFocusChangeListener(editTextSurname));
        editTextGrades.setOnFocusChangeListener(new MyFocusChangeListener(editTextGrades));

        //Odniesie się do klasy MyTextWatcher.java
        editTextName.addTextChangedListener(new MyTextWatcher(MainActivity.this));
        editTextSurname.addTextChangedListener(new MyTextWatcher(MainActivity.this));
        editTextGrades.addTextChangedListener(new MyTextWatcher(MainActivity.this));
    }

    //Gdy ta aktywność nie jest widoczna dla użytkownika i widoczna jest inna.
    @Override
    protected void onStop() {
        super.onStop();
    }

    //Gdy zostanie kliknięty button "Oceny".
    public void gradesButtonClicked (View view) {
        EditText gradesNumberEditText = findViewById(R.id.inputGrade);
        int gradesNumber = Integer.parseInt(gradesNumberEditText.getText().toString());
        Intent intent = new Intent(this, GradesActivity.class);
        intent.putExtra("GradesNumber", gradesNumber);
        this.startActivityForResult(intent, 100);
    }

    //Uruchamiany gdy działanie zakończy działanie.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.i("Finish", "test");
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode == Activity.RESULT_OK) {
            String message = intent.getStringExtra("GradesNumber");
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}
