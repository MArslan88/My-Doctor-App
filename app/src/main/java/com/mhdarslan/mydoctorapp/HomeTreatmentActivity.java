package com.mhdarslan.mydoctorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeTreatmentActivity extends AppCompatActivity {

    private ListView homeTreatmentlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_treatment);

        homeTreatmentlv = findViewById(R.id.homeTreatmentlv);

        String[] listOfDiseases = {
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
                "Depression"
        };

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listOfDiseases);
        homeTreatmentlv.setAdapter(adapter);


    }
}