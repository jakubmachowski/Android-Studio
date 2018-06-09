package com.marcin.lab01;

import android.app.Activity;
import android.content.Context;
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

        EditText editTextName = findViewById(R.id.nameEditText);
        EditText editTextSurname = findViewById(R.id.surnameEditText);
        EditText editTextGrades = findViewById(R.id.gradesNumberEditText);

        editTextName.setOnFocusChangeListener(new MyFocusChangeListener(editTextName));
        editTextSurname.setOnFocusChangeListener(new MyFocusChangeListener(editTextSurname));
        editTextGrades.setOnFocusChangeListener(new MyFocusChangeListener(editTextGrades));

        editTextName.addTextChangedListener(new MyTextWatcher(MainActivity.this));
        editTextSurname.addTextChangedListener(new MyTextWatcher(MainActivity.this));
        editTextGrades.addTextChangedListener(new MyTextWatcher(MainActivity.this));
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void gradesButtonClicked (View view) {

        EditText gradesNumberEditText = findViewById(R.id.gradesNumberEditText);

        int gradesNumber = Integer.parseInt(gradesNumberEditText.getText().toString());

        Intent intent = new Intent(this, GradesActivity.class);
        intent.putExtra("GradesNumber", gradesNumber);

        this.startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.i("Finish", "test");
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == Activity.RESULT_OK) {

            String message = intent.getStringExtra("GradesNumber");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
