package com.example.jmach.cw1;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DynamicViews {
    private int gradesNumber;

    public DynamicViews(int gradesNumber) {
        this.gradesNumber = gradesNumber;
    }

    //Metoda w której tworzony jest layout widoku.
    public LinearLayout setLinearLayoutHorizontal(Context context, int i) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setPadding(0,25,0,0);
        linearLayout.addView(setTextViews(context, "Ocena "+Integer.toString(i+1)+": "));
        linearLayout.addView(setRadioGroup(context, i));
        return linearLayout;
    }

    //Metoda w której jest tworzone pole tekstowe.
    private TextView setTextViews (Context context, String text) {
        TextView textView = new TextView(context);
        textView.setTextSize(20); //Ustawienie rozmiaru tekstu na: 20px.
        textView.setPadding(25,0,15,0); //Padding tekstu.
        textView.setTextColor(Color.LTGRAY); //Kolor tekstu.
        textView.setText(text); //Ustawienie tekstu na zmienną: text.
        return textView;
    }

    //Metoda w której tworzone jest grupa radiobuttonów.
    private RadioGroup setRadioGroup (Context context, int number) {
        RadioGroup radioGroup = new RadioGroup(context);
        String tag = "RadioGroup"+number; //Ustawienie zmiennej tag.
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        radioGroup.setPadding(25,0,0,0);
        radioGroup.setTag(tag); //Ustawienie tagu.
        radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener(gradesNumber, context));
        for (int i = 0; i < 4; i++ ) {
            radioGroup.addView(setRadioButton(context, Integer.toString(i+2), i, tag));
        }
        return radioGroup;
    }

    //Metoda w której tworzone są radiobuttony.
    private RadioButton setRadioButton(Context context, String text, int number, String tag) {
        RadioButton radioButton = new RadioButton(context);
        String tagButton = tag+"Button"+number;
        radioButton.setText(text);
        radioButton.setPadding(0,0,25,0);
        radioButton.setTag(tagButton);
        return radioButton;
    }

    //Metoda w której tworzony jest przycisk Gotowe.
    public Button setButton(Context context) {
        Button button = new Button(context);
        button.setVisibility(View.INVISIBLE); //Domyślnie ustawione na niewidoczny.
        button.setText("Oblicz średnią!"); //Ustawienie napisu na buttonie.
        button.setAllCaps(false); //Wyłączenie dużych liter.
        button.setTag("GotoweButton"); //Ustawienie tagu buttona.

        //Akcja kiedy nastąpi naciśnięcie w button.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator calculator = new Calculator(v.getContext());
                calculator.setGrades(gradesNumber);
            }
        });
        return button;
    }

    //Metoda w której jest tworzony seperator między oceniami.
    public View setView(Context context) {
        View view = new View(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 5);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(context.getResources().getColor(R.color.horizontalyLine));
        return  view;
    }
}