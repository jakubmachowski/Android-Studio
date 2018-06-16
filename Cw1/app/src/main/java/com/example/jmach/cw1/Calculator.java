package com.example.jmach.cw1;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class Calculator {
    Context context;
    int gradesArray[];

    public Calculator(Context context) {
        this.context = context;
    }

    public void setGrades(int numberGrades) {
        gradesArray = new int[numberGrades];

        Activity activity = (AppCompatActivity)context;
        LinearLayout linearLayout = activity.findViewById(R.id.GradesLayout);

        for (int i = 0; i < numberGrades; i++) {
            for (int j = 0; j < 4; j++) {
                String tagButton = "RadioGroup"+i+"Button"+j;
                RadioButton radioButton = linearLayout.findViewWithTag(tagButton);
                if (radioButton.isChecked()) {
                    gradesArray[i] = Integer.parseInt(radioButton.getText().toString());
                }
            }
        }
        calculateTheAverage(context);
    }

    private void calculateTheAverage(Context context) {
        Double sum = 0.0;

        for (int i : gradesArray) {
            sum += i;
        }
        Double average = sum/gradesArray.length;
        GradesActivity gradesActivity = (GradesActivity) context;
        gradesActivity.closeActivity(average);
    }
}
