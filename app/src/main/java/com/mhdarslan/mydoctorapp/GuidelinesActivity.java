package com.mhdarslan.mydoctorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GuidelinesActivity extends AppCompatActivity {

    private int positionTips;
    private TextView guidelineHeadingTxt, guidelinesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines);

        // Title of the Activity according to Intent position
        getSupportActionBar().setTitle("Guidelines");

        // get Intent position data from the previous Activity
        Intent intent = getIntent();
        positionTips = intent.getIntExtra("position",0);

        // Initialization
        guidelineHeadingTxt = findViewById(R.id.guidelineHeadingTxt);
        guidelinesText = findViewById(R.id.guidelinesText);

        String[] guidelinesArr = {
                "•\tWash your hands well.\n" +
                        "•\tCover a cough.\n" +
                        "•\tWash and bandage all cuts.\n" +
                        "•\tDo not pick at healing wounds or blemishes, or squeeze pimples.\n" +
                        "•\tDon't share dishes, glasses, or eating utensils.\n" +
                        "•\tAvoid direct contact with napkins, tissues, handkerchiefs, or similar items used by others.\n",

                "•\tRinse all meat, poultry, fish, fruits, and vegetables under running water before cooking or serving them.\n" +
                        "•\tWash your hands with soap and water before and after you handle raw meat.\n" +
                        "•\tSeparate raw foods and cooked foods. \n" +
                        "•\tCook foods thoroughly.\n" +
                        "•\tDefrost foods only in the refrigerator or in the microwave.\n",

                "•\tChildren should receive the recommended childhood vaccinations.\n" +
                        "•\tAdults should make sure their vaccinations are up to date.\n" +
                        "•\tWhen traveling abroad, check with your health care provider about additional immunizations.\n" +
                        "•\tMake sure your pet's vaccinations are up to date, too. \n",

                "•\tIf you are traveling to an area where insect-borne disease is present, take and use an insect repellent containing DEET.\n" +
                        "•\tDrink only bottled drinks.\n" +
                        "•\tBoil all tap water before drinking or drink only bottled water.\n" +
                        "•\tDo not eat uncooked vegetables.\n",

                "•\tUse insect repellents approved by the Environmental Protection Agency\n" +
                        "•\tLimit outdoor activity during peak mosquito hours of early morning and evening.\n" +
                        "•\tDrain any standing water near your home to prevent mosquitoes from breeding.\n\n",

                "•\tKeep food and garbage in covered, rodent-proof containers.\n" +
                        "•\tSeal holes and cracks in your home to deter rodent access.\n" +
                        "•\tClear brush and junk away from the foundation of your home.\n" +
                        "•\tDo not stir up dust in rodent-infested areas.\n" +
                        "•\tWhen outdoors, do not disturb rodent burrows or handle rodents.\n" +
                        "•\tIf your rodent problem is severe or persistent, consult a pest control expert.\n" +
                        "•\tStay clear of wild animals. Many wild animals, including raccoons, skunks, bats, foxes, and coyotes, can spread rabies to humans by biting.\n",

                "•\tWash your hands frequently and carefully\n" +
                        "•\tAvoid touching your face\n" +
                        "•\tStop shaking hands and hugging people \n" +
                        "•\tDon’t share personal items like phones, makeup, combs\n" +
                        "•\tCover your mouth and nose when you cough and sneeze\n" +
                        "•\tClean and disinfect surfaces\n" +
                        "•\tTake physical (social) distancing seriously\n" +
                        "•\tDo not gather in groups\n" +
                        "•\tAvoid eating or drinking in public places\n" +
                        "•\tWash fresh groceries\n" +
                        "•\tWear a (homemade) mask\n" +
                        "•\tSelf-quarantine if sick\n"
        };

        guidelineHeadingTxt.setText(PrevGuidelineActivity.headings[positionTips]);
        guidelinesText.setText(guidelinesArr[positionTips]);




    }
}