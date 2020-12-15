package com.mhdarslan.mydoctorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;

    private CardView healthDiaryCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        healthDiaryCardView = findViewById(R.id.healthDiaryCardView);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        RootRef = FirebaseDatabase.getInstance().getReference();

        healthDiaryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent healthDiaryIntent = new Intent(getApplicationContext(),HealthDiaryActivity.class);
                startActivity(healthDiaryIntent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(currentUser == null){ // this means the user is not Authenticated so we will send him first at login activity
            sendUserToOnBoardingActivity();
        }else{ // if user is already logedIn
            VerifyUserExistance();
        }
    }

    private void VerifyUserExistance() {
        String currentUserID = mAuth.getCurrentUser().getUid(); // we will get the id of the current user
        // we are checking for this user Authentication

        RootRef.child("Users").child(currentUserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if((dataSnapshot.child("fname").exists())){
                    // Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                }else{ // if the name is not available so it means the user is new user
                    sendUserToProfileActivity();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //to get menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    // to get options of the menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.main_logout_option){  // this is for sign out option menu
            mAuth.signOut();
            sendUserToOnBoardingActivity();
        }
        if(item.getItemId() == R.id.main_profile_option){  // this is for profile option menu
            sendUserToProfileActivity();
        }
        
        return true;
    }

    private void sendUserToLoginActivity() {
        Intent loginIntenet = new Intent(MainActivity.this,LoginActivity.class);
        // this will stop the user to get again the MainActivity when user press the back button
        loginIntenet.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntenet);
        finish();
    }

    private void sendUserToOnBoardingActivity() {
        Intent loginIntenet = new Intent(MainActivity.this,OnboardingActivity.class);
        // this will stop the user to get again the MainActivity when user press the back button
        loginIntenet.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntenet);
        finish();
    }

    private void sendUserToProfileActivity() {
        Intent profileIntenet = new Intent(MainActivity.this,ProfileActivity.class);
//        // this will stop the user to get again the MainActivity when user press the back button
//        profileIntenet.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(profileIntenet);
//        finish();
    }
}