package com.mhdarslan.mydoctorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int positionDiseases;
    private TextView headingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        headingText = findViewById(R.id.headingText);

        Intent intent = getIntent();
        positionDiseases = intent.getIntExtra("position",0);

        // Title of the Activity according to Intent position
        getSupportActionBar().setTitle(HomeTreatmentActivity.listOfDiseases[positionDiseases]);

        headingText.setText("Get to know about \n"+HomeTreatmentActivity.listOfDiseases[positionDiseases]);


    }
}