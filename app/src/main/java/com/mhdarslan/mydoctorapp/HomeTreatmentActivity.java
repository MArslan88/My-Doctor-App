package com.mhdarslan.mydoctorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeTreatmentActivity extends AppCompatActivity {

    private ListView homeTreatmentlv;
    public static String[] listOfDiseases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_treatment);

        // Title of the activity
        getSupportActionBar().setTitle("List of Diseases");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        homeTreatmentlv = findViewById(R.id.homeTreatmentlv);

        listOfDiseases = new String[] {
                "Headache",
                "Fever",
                "Cough",
                "Throat Infection",
                "Common Flu",
                "Mouth, Gum and Teeth Issues",
                "Gastro Intestinal",
                "Eyes Pain",
                "Pink/red Eyes",
                "Insomnia",
                "Chest Pain",
                "Diabetes",
                "Kidney Issues",
                "Head Lice",
                "Burns",
                "Knee Pain",
                "High Blood Pressure",
                "Acne",
                "Constipation",
                "Depression",
        };



        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listOfDiseases);
        homeTreatmentlv.setAdapter(adapter);

        // clickListener
        homeTreatmentlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // open the DetailActivity with position data of the clicked list item
                startActivity(new Intent(getApplicationContext(),DetailActivity.class).putExtra("position",position));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}