package com.example.student.start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean nazwiskoNiePuste = false;
    boolean imieNiePuste = false;
    boolean liczbaOcenyNiePuste = false;
    Integer oceny = 0;
//    int nazwiskoLenght;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editTextNazwisko = findViewById(R.id.editTextNazwisko);
        final EditText editTextImie = findViewById(R.id.editTextImie);
        final EditText editTextOcena = findViewById(R.id.editTextOceny);


        Button b = (Button) findViewById(R.id.button5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent drugazStrona = new Intent(MainActivity.this, Main2Activity.class);

                drugazStrona.putExtra("iloscOcen", oceny);
                startActivityForResult(drugazStrona, 1);
            }
        });


        editTextImie.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (editTextImie.isFocused()) {
                    Log.d("Test focus: ", String.valueOf(editTextImie.isFocused()));
                    Toast.makeText(MainActivity.this, "Wprowadz Imie", Toast.LENGTH_SHORT).show();
                }
            }
        });
        editTextNazwisko.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (editTextNazwisko.isFocused()) {
                    Toast.makeText(MainActivity.this, "Wprowadz Nazwisko", Toast.LENGTH_SHORT).show();
                }
            }
        });
        editTextOcena.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (editTextOcena.isFocused()) {
                    Toast.makeText(MainActivity.this, "Wprowadz Oceny", Toast.LENGTH_SHORT).show();
                }
            }
        });


        editTextImie.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //   Toast.makeText(MainActivity.this, "Wprowadz Imie", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sprawdzImie();
                showButton();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        editTextNazwisko.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //   Toast.makeText(MainActivity.this, "Wprowadz Nazwisko", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sprawdzNazwisko();
                showButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editTextOcena.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //    Toast.makeText(MainActivity.this, "Wprowadz Liczbe przedmiotow", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                sprawdzOceny();
                showButton();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//        editTextImie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sprawdzImie();
//            }
//        });
//        editTextNazwisko.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sprawdzNazwisko();
//            }
//        });
//        editTextOcena.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sprawdzOceny();
//            }
//        });
//        editTextNazwisko.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//
//                //   onFocusNazwisko();
//            }
//        });
//
//        editTextImie.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                //    onFocusImie();
//            }
//        });
//        editTextOcena.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean b) {
//                // onFocusOceny();
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dane) {
        super.onActivityResult(requestCode, resultCode, dane);
        if (resultCode == RESULT_OK) {
            final EditText editTextNazwisko = findViewById(R.id.editTextNazwisko);
            final EditText editTextImie = findViewById(R.id.editTextImie);
            final EditText editTextOcena = findViewById(R.id.editTextOceny);

            Bundle ocenaPrzekazana = dane.getExtras();
            double ocenaSrednia = ocenaPrzekazana.getDouble("serdniaWynik");
            Toast.makeText(MainActivity.this, "Srednia Ocen" + String.valueOf(ocenaSrednia), Toast.LENGTH_SHORT).show();
            editTextNazwisko.setEnabled(false);
            editTextImie.setEnabled(false);
            editTextOcena.setEnabled(false);

        }
    }

    private void sprawdzNazwisko() {
        EditText b = (EditText) findViewById(R.id.editTextNazwisko);
        String s = b.getText().toString();
        Integer a = s.length();
        if (a > 0) {
            //  Toast.makeText(this, a.toString(), Toast.LENGTH_SHORT).show();
            nazwiskoNiePuste = true;

        } else {
            //  Toast.makeText(this, "Wprowadz Nazwisko", Toast.LENGTH_SHORT).show();
            nazwiskoNiePuste = false;

        }
        showButton();
    }

    private void sprawdzImie() {
        EditText b = (EditText) findViewById(R.id.editTextImie);
        String s = b.getText().toString();
        Integer a = s.length();
        if (a > 0) {
            //  Toast.makeText(this, a.toString(), Toast.LENGTH_SHORT).show();
            imieNiePuste = true;

        } else {
            //   Toast.makeText(this, "Wprowadz Imie", Toast.LENGTH_SHORT).show();
            imieNiePuste = false;

        }
        showButton();
    }

    private void sprawdzOceny() {
        EditText b = (EditText) findViewById(R.id.editTextOceny);
        String s = b.getText().toString();
        Integer a = s.length();
        Integer ocenyWartosc = 0;
        if (a > 0) {
            oceny = Integer.valueOf(s);
        }
        if (oceny > 4 && oceny < 16) {
            //   Toast.makeText(this, a.toString(), Toast.LENGTH_SHORT).show();
            liczbaOcenyNiePuste = true;

        } else {
            Toast.makeText(this, "Wprowadz Oceny od 5 do 15", Toast.LENGTH_SHORT).show();
            liczbaOcenyNiePuste = false;

        }
        showButton();
    }

    private void showButton() {
        Button b = (Button) findViewById(R.id.button5);
        EditText i = (EditText) findViewById(R.id.editTextOceny);
        Integer z = i.getText().toString().length();
        if ((nazwiskoNiePuste) && (imieNiePuste) && (liczbaOcenyNiePuste)) {
            b.setVisibility(View.VISIBLE);

        } else {
            b.setVisibility(View.INVISIBLE);
        }

    }


}