package com.mhdarslan.mydoctorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mhdarslan.mydoctorapp.covidtracker.CovidTrackerActivity;

public class MainActivity2 extends AppCompatActivity {

    private CardView covidTrackerCardView, chatCardView,healthDiaryCardView,
            homeTreatmentCardView, prevGuideCardView, healthTipsCardView, disAvoidanceCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        covidTrackerCardView = findViewById(R.id.covidTrackerCardView);
        chatCardView = findViewById(R.id.chatCardView);
        healthDiaryCardView = findViewById(R.id.healthDiaryCardView);
        homeTreatmentCardView = findViewById(R.id.homeTreatmentCardView);
        prevGuideCardView = findViewById(R.id.prevGuideCardView);
        healthTipsCardView = findViewById(R.id.healthTipsCardView);
        disAvoidanceCardView = findViewById(R.id.disAvoidanceCardView);


        // Covid Tracker CardView click listener
        covidTrackerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent covidIntent = new Intent(getApplicationContext(), CovidTrackerActivity.class);
                startActivity(covidIntent);
            }
        });

        // Chat CardView click listener
        chatCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "You need to login for this feature.", Toast.LENGTH_SHORT).show();
            }
        });

        // healthDiaryCardView click listener
        healthDiaryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this, "You need to login for this feature.", Toast.LENGTH_SHORT).show();
            }
        });

        // homeTreatmentCardView click listener
        homeTreatmentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeTreatmentIntent = new Intent(getApplicationContext(),HomeTreatmentActivity.class);
                startActivity(homeTreatmentIntent);
            }
        });

        // prevGuideCardView click listener
        prevGuideCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prevGuideIntent = new Intent(getApplicationContext(),PrevGuidelineActivity.class);
                startActivity(prevGuideIntent);
            }
        });

        // healthTipsCardView click listener
        healthTipsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent healthTipsIntent = new Intent(getApplicationContext(),HealthTipsActivity.class);
                startActivity(healthTipsIntent);
            }
        });

        // disAvoidanceCardView click listener
        disAvoidanceCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disAvoidanceIntent = new Intent(getApplicationContext(),PrecautionsActivity.class);
                startActivity(disAvoidanceIntent);
            }
        });
    }
}