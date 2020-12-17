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
            "Avoid direct contact with napkins, tissues, handkerchiefs, or similar items used by others",
            "Rinse all meat, poultry, fish, fruits, and vegetables under running water before cooking or serving them.",
            "When traveling abroad, check with your health care provider about additional immunizations.",
            "If you are traveling to an area where insect-borne disease is present, take and use an insect repellent containing DEET",
            "Limit outdoor activity during peak mosquito hours of early morning and evening.",
            "Stay clear of wild animals. Many wild animals, including raccoons, skunks, bats, foxes, and coyotes, can spread rabies to humans by biting.",
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