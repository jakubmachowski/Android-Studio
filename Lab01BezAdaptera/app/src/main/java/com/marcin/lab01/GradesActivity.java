package com.marcin.lab01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class GradesActivity extends AppCompatActivity {

    DynamicViews dynamicViews;
    LinearLayout linearLayout;
    Bundle bundle;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        bundle = getIntent().getExtras();
        number = bundle.getInt("GradesNumber");

        dynamicViews = new DynamicViews(number);

        linearLayout = findViewById(R.id.GradesLayout);

        for (int i = 0; i < number; i++) {
            linearLayout.addView(dynamicViews.setLinearLayoutHorizontal(this, i));
            if (i < number-1){
                linearLayout.addView(dynamicViews.setView(this));
            }
        }
        linearLayout.addView(dynamicViews.setButton(GradesActivity.this));
    }

    public void closeActivity(Double average) {
        Intent intent = new Intent();
        intent.putExtra("GradesNumber", Double.toString(average));
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
