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

public class PrecautionsActivity extends AppCompatActivity {

    ArrayList<Word> precautionsModels;
    ListView precautions_lv;
    public static String [] headings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precautions_avoidance);

        // Title of the Activity according to Intent position
        getSupportActionBar().setTitle("Precautions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        precautions_lv = findViewById(R.id.precautions_lv);

        headings = new String[]{
                "Avoid Slips and Falls",
                "Avoid Cuts",
                "Avoid Burns",
                "Avoid Nosebleed",
                "Avoid Toothaches"
        };

        String [] descriptions = {
                "For younger children, be sure to properly install and use safety gates around stairways.",
                "Keep a first aid kit handy for when cuts do occur.",
                "Be particularly careful when working with hot liquids.",
                "Sit up, don’t lie down. Keep your head above your heart.",
                "Dental sealants a preventative measure for a toothache remedy that lasts."
        };

        // Initialize Arraylist
        precautionsModels = new ArrayList<>();
        for(int i=0; i<headings.length; i++){
            Word words = new Word(headings[i],descriptions[i]);
            precautionsModels.add(words);
        }

        //set onItem ClickListener
        precautions_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // open the HealthTips Activity with position data of the clicked list item
                startActivity(new Intent(getApplicationContext(), PrecautionsDetailActivity.class).putExtra("position",position));
            }
        });

        // ArrayAdapter
        GuidelineAdapter guidelineAdapter = new GuidelineAdapter(this,precautionsModels);
        precautions_lv.setAdapter(guidelineAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}