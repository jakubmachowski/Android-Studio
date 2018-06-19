package com.example.student.start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private Integer oceny = 0;
    private int srednia;
    private double sredniawynik;
    ListView list;
    ArrayList<ModelOceny> dane = new ArrayList<ModelOceny>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Bundle bunOceny = getIntent().getExtras();
        oceny = bunOceny.getInt("iloscOcen");
        Toast.makeText(Main2Activity.this, String.valueOf(oceny), Toast.LENGTH_SHORT).show();
        final Button btSrednia = (Button) findViewById(R.id.srednia);
        btSrednia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                srednia = 0;
                for (int i = 0; i < oceny; i++) {
                    srednia += dane.get(i).getOcena();
                }
                int sredniaInt;
                sredniawynik = ((double) srednia / (double) oceny) * 100;
                sredniaInt = (int) sredniawynik;
                sredniawynik = (double) sredniaInt;
                sredniawynik = sredniawynik / 100.0;
                btSrednia.setText(String.valueOf(sredniawynik));

                Bundle ocenaDoPRzekazania = new Bundle();
                ocenaDoPRzekazania.putDouble("serdniaWynik", sredniawynik);
                Intent powrot = new Intent();
                powrot.putExtras(ocenaDoPRzekazania);
                setResult(RESULT_OK,powrot);

                finish();
            }
        });
//        TextView tv1 = (TextView) findViewById(R.id.textViewOceny2ac);
//        tv1.setText((tv1.toString())+" 1");


        for (int a = 0; a < oceny; ++a) {
            dane.add(new ModelOceny("Ocena", String.valueOf(a + 1), 3));
        }
        //      łączenie danych z listą
        InteraktywnyAdapterTablicy adapter = new InteraktywnyAdapterTablicy(this, dane);
        list = (ListView) findViewById(R.id.myListSecondLay);
        list.setAdapter(adapter);

        //     list = (ListView) findViewById(R.id.myListSecondLay);

        //     ArrayAdapter <ModelOceny> adapter = new ArrayAdapter<ModelOceny>(this, R.layout.listview, R.id.textViewOceny2ac, dane);


        list.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        for (int i = 0; i < oceny; i++) {
            outState.putString(String.valueOf(i), String.valueOf(dane.get(i).getOcena()));
        }
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (int i = 0; i < oceny; i++) {
            String s = (String) savedInstanceState.get(String.valueOf(i));
            dane.get(i).setOcena(Integer.valueOf(s));
        }
    }
}
