package com.example.student.start;
import android.widget.RadioGroup;
import android.widget.TextView;

class ModelOceny {
        private String nazwa;
        private String pozycja;
        private int ocena;
//        private TextView tv1;
//        private TextView tv2;



        public ModelOceny()
        {
        }

        public ModelOceny(String _nazwa, String _pozycja,int _oceny)
        {
            this.nazwa = _nazwa;
            ocena = _oceny;
            pozycja = _pozycja;

        }

        public String getModelOcena()
        {
            return this.nazwa+" "+pozycja;
//                    ocena;
        }


    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setPozycja(String pozycja) {
        this.pozycja = pozycja;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getPozycja() {
        return pozycja;
    }

    public int getOcena() {
        return ocena;
    }

    @Override
        public String toString() {
                return this.nazwa+" "+ pozycja;
        }
}
