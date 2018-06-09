package com.marcin.lab01;

import android.content.Context;
import android.graphics.Color;
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

    public LinearLayout setLinearLayoutHorizontal(Context context, int i) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = getLayoutParams(-1, -2);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setPadding(0,25,0,0);
        linearLayout.addView(setTextViews(context, "Ocena "+Integer.toString(i+1)+": "));
        linearLayout.addView(setRadioGroup(context, i));
        return linearLayout;
    }

    private TextView setTextViews (Context context, String text) {
         ViewGroup.LayoutParams layoutParams = getLayoutParams(-2, -2);
         TextView textView = new TextView(context);
         textView.setLayoutParams(layoutParams);
         textView.setTextSize(20);
         textView.setPadding(25,0,15,0);
         textView.setTextColor(Color.rgb(0,0,0));;
         textView.setText(text);
         return textView;
    }

    private RadioGroup setRadioGroup (Context context, int number) {
        RadioGroup radioGroup = new RadioGroup(context);

        String tag = "RadioGroup"+number;

        ViewGroup.LayoutParams layoutParams = getLayoutParams(-1, -2);
        radioGroup.setLayoutParams(layoutParams);
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        radioGroup.setPadding(25,0,0,0);
        radioGroup.setTag(tag);
        radioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener(gradesNumber, context));
        for (int i = 0; i < 4; i++ ) {
            radioGroup.addView(setRadioButton(context, Integer.toString(i+2), i, tag+i));
        }
        return radioGroup;
    }

    private RadioButton setRadioButton(Context context, String text, int number, String tag) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams(-2, -1);
        RadioButton radioButton = new RadioButton(context);
        radioButton.setText(text);
        radioButton.setPadding(0,0,25,0);
        radioButton.setTag(tag);
        radioButton.setLayoutParams(layoutParams);
        return radioButton;
    }

    public Button setButton(Context context) {
        Button button = new Button(context);
        ViewGroup.LayoutParams layoutParams = getLayoutParams(-1, -2);
        button.setLayoutParams(layoutParams);
        button.setVisibility(View.INVISIBLE);
        button.setText("Gotowe!");
        button.setTag("GotoweButton");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculator calculator = new Calculator(v.getContext());
                calculator.setGrades(gradesNumber);
            }
        });
        return button;
    }

    public View setView(Context context) {
        View view = new View(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 5);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(context.getResources().getColor(R.color.horizontalyLine));
        return  view;
    }

    //-1 is MATCH_PARENT, -2 is WRAP_CONTENT
    private ViewGroup.LayoutParams getLayoutParams(int width, int height) {
        return new LinearLayout.LayoutParams(width, height);
    }
}
