package com.example.jmach.cw1;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
    private int numberRadioGroup;
    private boolean[] radioGroupFlagArray;
    private Context context;

    public MyOnCheckedChangeListener(int numberRadioGroup, Context context) {
        this.numberRadioGroup = numberRadioGroup;
        this.context = context;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        radioGroupFlagArray = new boolean[numberRadioGroup];
        Activity activity;
        activity = (AppCompatActivity) context;
        LinearLayout gradesLayout = activity.findViewById(R.id.GradesLayout);
        checkSelectedRadioGroups(gradesLayout);
        if (checkSelectedAllRadioGroups()) {
            setButtonGotowe(gradesLayout, true);
        } else {
            setButtonGotowe(gradesLayout, false);
        }
    }

    private void checkSelectedRadioGroups(LinearLayout gradesLayout) {
        for (int i = 0; i < numberRadioGroup; i++) {
            String tag = "RadioGroup"+i;
            RadioGroup radioGroup = gradesLayout.findViewWithTag(tag);
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                radioGroupFlagArray[i] = false;
            } else {
                radioGroupFlagArray[i] = true;
            }
        }
    }

    private Boolean checkSelectedAllRadioGroups() {
        for (boolean i : radioGroupFlagArray) {
            if (!i) {
                return false;
            }
        }
        return true;
    }

    private void setButtonGotowe(LinearLayout gradesLayout, Boolean visible) {
        Button button = gradesLayout.findViewWithTag("GotoweButton");
        if (visible) {
            button.setVisibility(View.VISIBLE);
        } else {
            button.setVisibility(View.INVISIBLE);
        }
    }
}
