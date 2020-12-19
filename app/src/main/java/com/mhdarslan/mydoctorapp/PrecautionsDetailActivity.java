package com.mhdarslan.mydoctorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PrecautionsDetailActivity extends AppCompatActivity {

    private int positionPrecautions;
    private TextView precautionHeadingTxt, precautionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precautions_detail);

        // get Intent position data from the previous Activity
        Intent intent = getIntent();
        positionPrecautions = intent.getIntExtra("position",0);

        // Title of the Activity according to Intent position
        getSupportActionBar().setTitle(PrecautionsActivity.headings[positionPrecautions]);

        // Initialization
        precautionHeadingTxt = findViewById(R.id.precautionHeadingTxt);
        precautionText = findViewById(R.id.precautionText);

        // Health Tips Array
        String[] precautionsArr = {
                "•\tFor younger children, be sure to properly install and use safety gates around stairways.\n" +
                        "•\tFor all age groups, it is recommended to try and keep things off of the floor that might lead to a dangerous slip or fall.\n" +
                        "•\tEncourage your family to put things away after they are done, and set a good example by doing so yourself.\n" +
                        "•\tFor the elderly, strength and balance exercises should be prioritized Tai Chi or yoga are great examples for this. \n" +
                        "•\tMake sure that your eyes are checked at least once a year and that all of your corrective lens prescriptions are up to date. Make the home safer by installing railing on both sides of the stairway or grip bars in the shower.\n" +
                        "•\tFinally, make sure that the lights in your home are all working and operational.\n",

                "•\tIn the kitchen, cuts are one of the most common injuries. These can be more easily avoided by making sure your knives are sharp a dull knife is more likely to slip and cause an injury than a properly edged one. \n" +
                        "•\tBe sure to keep your knives properly stored when not in use, suck as in a knife block (which can also help keep their edge sharper than storing in a drawer).\n" +
                        "•\tAlso, it is important to never leave a knife where it is unlikely to be seen. Placing a knife in a soapy sink, for instance, could lead to a cut as you do the dishes later.\n" +
                        "•\tKeep a first aid kit handy for when cuts do occur.\n" +
                        "•\tMake sure it is stocked with a variety of bandages to accommodate injuries on different parts of the body a cut on your knuckle may require a different bandage than one on the palm of the hand. \n" +
                        "•\tBe sure to clean any wounds before they are bandaged as well, and to replace the bandages as needed while they heal.\n",

                "•\tLike cuts, burns are likely to happen in the kitchen. Always use an oven mitt when possible, and make sure to regularly replace yours as they begin to wear thin. \n" +
                        "•\tBe particularly careful when working with hot liquids of any kind, as hot oil or boiling water can splatter and cause burns as easily as a hot pan.\n" +
                        "•\tBe mindful to keep pot and pan handles facing inwards towards the stove to avoid them from being accidentally caught and tipped over especially if there are small children in the home.\n" +
                        "•\tKeeping the maximum temperature below 120 degrees can prevent your family and guests from burning themselves when washing their hands or stepping into the shower.\n",

                "•\tStay calm. If you start to get nervous, it can actually make you bleed more. Try to relax.\n" +
                        "•\tSit up, don’t lie down. Keep your head above your heart.\n" +
                        "•\tLean a little bit forward. This keeps the blood from draining down the back of your throat.\n" +
                        "•\tPinch your nostrils closed. Use your thumb and index finger to hold your nostrils closed for 5 to 10 minutes while you breathe through your mouth.\n" +
                        "•\tDon’t use cold and allergy medications too often. \n" +
                        "•\tDon’t pick your nose. \n" +
                        "•\tUse a saline nasal product. \n",

                "Brush teeth regularly\n" +
                        "•\tFloss your teeth regularly\n" +
                        "•\tMake a your dental checkup routine\n" +
                        "•\tFluoride treatments\n" +
                        "•\tAdd healthy foods to your diet\n" +
                        "•\tDental sealants a preventative measure for a toothache remedy that lasts\n" +
                        "•\tClean your tongue\n" +
                        "•\tUse a fresh toothbrush\n" +
                        "•\tGargle with salt water\n"
        };

        precautionHeadingTxt.setText(PrecautionsActivity.headings[positionPrecautions]);
        precautionText.setText(precautionsArr[positionPrecautions]);
    }
}