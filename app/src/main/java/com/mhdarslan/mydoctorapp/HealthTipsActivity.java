package com.mhdarslan.mydoctorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HealthTipsActivity extends AppCompatActivity {

    ArrayList<Word> tipsModels;
    ListView healthTips_lv;
    public static String [] headings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        // Title of the Activity according to Intent position
        getSupportActionBar().setTitle("Health Tips");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        healthTips_lv = findViewById(R.id.healthTips_lv);

        headings = new String[]{
                "Healhy Eating",
                "Tips for special situations",
                "Consequences of physical inactivity and lack of exercise",
                "Mental Health",
                "Avoid high-risk behaviors",
                "Fat-Burning Foods for good Health"
        };

        String [] descriptions = {
                "Avoid heavy meals in the summer months, especially during hot days.",
                "Exercise can be broken up into smaller 10-minute sessions",
                "Physical inactivity and lack of exercise contribute to weight gain",
                "Do some mind exercises (read, do a puzzle occasionally during the week).",
                "Possession of firearms and guns without proper training and storage",
                "help you lose weight. Coffee does stimulate the metabolism."
        };

        // Initialize Arraylist
        tipsModels = new ArrayList<>();
        for(int i=0; i<headings.length; i++){
            Word words = new Word(headings[i],descriptions[i]);
            tipsModels.add(words);
        }

        //set onItem ClickListener
        healthTips_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // open the HealthTips Activity with position data of the clicked list item
                startActivity(new Intent(getApplicationContext(), TipsDetailActivity.class).putExtra("position",position));
            }
        });

        // ArrayAdapter
        GuidelineAdapter guidelineAdapter = new GuidelineAdapter(this,tipsModels);
        healthTips_lv.setAdapter(guidelineAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}