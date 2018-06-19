package com.example.student.start;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class InteraktywnyAdapterTablicy extends ArrayAdapter<ModelOceny> {

    //przechowujemy referencję do listy ocen
    private List<ModelOceny> listaOcen;
    private Activity kontekst;

    public InteraktywnyAdapterTablicy(Activity kontekst, List<ModelOceny> listaOcen) {
        super(kontekst, R.layout.activity_main2, listaOcen);
        this.kontekst = kontekst;
        this.listaOcen = listaOcen;

    }

    //tworzenie nowego wiersza
    @Override
    public View getView(int numerWiersza, View widokDoRecyklingu, ViewGroup parent) {
        View widok = null;
        //tworzenie nowego wiersza
        if (widokDoRecyklingu == null) {
            //    widok = kontekst.getLayoutInflater().inflate(R.layout.listview,null);
            LayoutInflater pompka = kontekst.getLayoutInflater();
            widok = pompka.inflate(R.layout.listview, null);

            //utworzenie layout na podstawie pliku XML
            //wybranie konkretnego przycisku radiowego musi zmieniać dane w modelu
            RadioGroup grupaOceny = (RadioGroup) widok.findViewById(R.id.RadioGrupTV);
            grupaOceny.check(R.id.radioButton3);
            grupaOceny.setOnCheckedChangeListener(
                    new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, //referencja do grupy
                                                     //przycisków
                                                     int checkedId) //identyfikator wybranego
                        //przycisku
                        {
                            ModelOceny element = (ModelOceny) group.getTag();

                            // 1) odczytanie z etykiety, który obiekt modelu przechowuje dane o
                            //zmienionej ocenie
//                            element.setOcena(checkedId);
                            switch (checkedId)
                            {
                                case R.id.radioButton2:element.setOcena(2);
                                break;
                                case R.id.radioButton3:element.setOcena(3);
                                    break;
                                case R.id.radioButton4:element.setOcena(4);
                                    break;
                                case R.id.radioButton5:element.setOcena(5);
                                    break;


                            }
                            // 2) zapisanie zmienionej oceny


                        }
                    }
            );
            grupaOceny.setTag(listaOcen.get(numerWiersza));

            //powiązanie grupy przycisków z obiektem w modelu
        }
        //aktualizacja istniejącego wiersza
        else {
            widok = widokDoRecyklingu;
            RadioGroup grupaOceny = (RadioGroup) widok.findViewById(R.id.RadioGrupTV);
            grupaOceny.setTag(listaOcen.get(numerWiersza));

            //powiązanie grupy przycisków z obiektem w modelu
        }

        TextView etykieta = (TextView) widok.findViewById(R.id.myListSecondLay);

        //ustawienie tekstu etykiety na podstawie modelu
        RadioGroup grupaOceny = (RadioGroup) widok.findViewById(R.id.RadioGrupTV);

        //zaznaczenie odpowiedniego przycisku na podtawie modelu
        grupaOceny.getTag();
        int ocena = listaOcen.get(numerWiersza).getOcena();

        switch (ocena) {
            case 2: grupaOceny.check(R.id.radioButton2);
                break;
            case 3:grupaOceny.check(R.id.radioButton3);
                break;

            case 4:grupaOceny.check(R.id.radioButton4);
                break;
            case 5:grupaOceny.check(R.id.radioButton5);
                break;
        }
        //zwrócenie nowego lub zaktualizowanego wiersza listy
        return widok;
    }
};

