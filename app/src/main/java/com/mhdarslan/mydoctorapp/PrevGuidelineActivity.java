package com.mhdarslan.mydoctorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PrevGuidelineActivity extends AppCompatActivity {

    ArrayList<Word> guidelinesModels;
    ListView prev_guide_lv;
    public static String [] headings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prev_guideline);

        // Title of the Activity according to Intent position
        getSupportActionBar().setTitle("Prevention Guideline");

        prev_guide_lv = findViewById(R.id.prev_guide_lv);

        headings = new String[]{
          "Good hygiene: the primary way to prevent infections",
          "Practice good food-safety techniques to avoid getting sick",
          "Vaccinations are essential if you are to avoid getting sick",
          "Take travel precautions",
          "Avoiding bug-borne pathogens",
          "Using animal-control to prevent infections",
          "Coronavirus (COVID-19) Prevention"
        };

        String [] descriptions = {
            "Don't share dishes, glasses, or eating utensils.",
            "Defrost foods only in the refrigerator or in the microwave.",
            "Children should receive the recommended childhood vaccinations.",
            "Boil all tap water before drinking or drink only bottled water.",
            "Use insect repellents approved by the Environmental Protection Agency",
            "Keep food and garbage in covered, rodent-proof containers.",
            "Don’t share personal items like phones, makeup, combs"
        };

        // Initialize Arraylist
        guidelinesModels = new ArrayList<>();
        for(int i=0; i<headings.length; i++){
            Word words = new Word(headings[i],descriptions[i]);
            guidelinesModels.add(words);
        }

        //set onItem ClickListener
        prev_guide_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // open the HealthTips Activity with position data of the clicked list item
                startActivity(new Intent(getApplicationContext(), GuidelinesActivity.class).putExtra("position",position));
            }
        });

        // ArrayAdapter
        GuidelineAdapter guidelineAdapter = new GuidelineAdapter(this,guidelinesModels);
        prev_guide_lv.setAdapter(guidelineAdapter);
    }
}