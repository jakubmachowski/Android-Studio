package com.example.jmach.cw2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class DrawingField extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    //Pozwala kontrolować i monitorować powierzchnię.
    private SurfaceHolder mPojemnik;

    //Wątek, który odświeża kanwę.
    private Thread mWatekRysujacy;

    //Flaga logiczna do kontrolowania pracy wątku.
    private boolean mWatekPracuje = false;

    //Obiekt do tworzenia sekcji krytycznych.
    private Object mBlokada = new Object();

    public DrawingField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        //Pojemnik powierzchni - pozwala kontrolować i monitorować powierzchnię.
        mPojemnik = getHolder();
        mPojemnik.addCallback(this);

        //Inicjacja innych elementów...
    }

    public void wznowRysowanie() {
        //Uruchomienie wątku rysującego.
        mWatekRysujacy = new Thread(this);
        mWatekPracuje = true;
        mWatekRysujacy.start();
    }

    public void pauzujRysowanie() {
        mWatekPracuje = false;
    }

    //Obsługa dotknięcia ekranu.
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        performClick();

        //Sekcja krytyczna - modyfikacja rysunku na wyłączność.
        synchronized (mBlokada) {
            //Modyfikacja rysunku.
        }
        return true;
    }

    //Żeby lint nie wyświetlał ostrzeżeń - onTouchEvent i performClick trzeba implementować razem.
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public void run() {
        while (mWatekPracuje) {
            Canvas kanwa = null;
            try {
                //Sekcja krytyczna - żaden inny wątek nie może używać pojemnika.
                synchronized (mPojemnik) {
                    //Czy powierzchnia jest prawidłowa?
                    if (!mPojemnik.getSurface().isValid()) {
                        continue;
                    }
                    //Zwaraca kanwę, na której można rysować, każdy pixel kanwy w prostokącie przekazanym jako parametr musi być narysowany od nowa inaczej: rozpoczecie edycji zawartości kanwy.
                    kanwa = mPojemnik.lockCanvas(null);
                    //Sekcja krytyczna - dostęp do rysunku na wyłączność.
                    synchronized (mBlokada) {
                        if (mWatekPracuje) {
                            //Rysowanie na lokalnej kanwie...
                        }
                    }
                }
            } finally {
                //W bloku finally - gdyby wystąpił wyjątek w powyższym powierzchnia zostanie zostawiona na spójnym ekranie.
                mPojemnik.unlockCanvasAndPost(kanwa);
            }
        } try {
            Thread.sleep(1000 / 25); //25
        } catch (InterruptedException e) {

        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //Inicjalizacja...
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //Zatrzymanie rysowania.
        mWatekPracuje = false;
    }
}
