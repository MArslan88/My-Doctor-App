package com.mhdarslan.mydoctorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leo.simplearcloader.SimpleArcLoader;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {

    private EditText fnInput, lnInput, phInput;
    private Button updateBtn;
    private String currentUserID;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;
    private Boolean IS_DATA_FETCHED = false;

    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Title of the activity
        getSupportActionBar().setTitle("Profile");


        // Initialization
        mAuth= FirebaseAuth.getInstance();
        currentUserID=mAuth.getCurrentUser().getUid();
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.keepSynced(true);

        fnInput = findViewById(R.id.fnInput);
        lnInput = findViewById(R.id.lnInput);
        phInput = findViewById(R.id.phInput);
        updateBtn = findViewById(R.id.updateBtn);

        simpleArcLoader = findViewById(R.id.loader);
        scrollView = findViewById(R.id.scrollProfile);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateProfile();
            }
        });

        RetrieveUserInfo();

    }

    private void RetrieveUserInfo() {
        // Start the Arcloader while App is fetching the User Info from the server
        simpleArcLoader.start();

        RootRef.child("Users").child(currentUserID)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if((dataSnapshot.exists()) && (dataSnapshot.hasChild("fname") && (dataSnapshot.hasChild("lname")))){ // if user is updated his profile then

                            String retrieveFirstName = dataSnapshot.child("fname").getValue().toString();
                            String retrieveLastName = dataSnapshot.child("lname").getValue().toString();
                            String retrieveUserNumber = dataSnapshot.child("number").getValue().toString();

                            // retrieveUserName will be shown to userName EditText again
                            fnInput.setText(retrieveFirstName);
                            lnInput.setText(retrieveLastName);
                            phInput.setText(retrieveUserNumber);                            
                           
                            IS_DATA_FETCHED = true;

                            // stop the SimpleArc Loader
                            simpleArcLoader.stop();

                            // now hide the Arc Loader and show the ScrollView and its contents
                            simpleArcLoader.setVisibility(View.GONE);
                            scrollView.setVisibility(View.VISIBLE);

                        }else{ // if none of these exist
                            Toast.makeText(ProfileActivity.this, "Please update your information...!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });


        // Post Delay Handler for checking Internet connectivity
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!IS_DATA_FETCHED == true){
                    Toast.makeText(ProfileActivity.this, "Please check your Internet connection...!", Toast.LENGTH_SHORT).show();
                }else {
//                    Toast.makeText(ProfileActivity.this, "Connected...!", Toast.LENGTH_SHORT).show();
                }
            }
        }, 5000);
    }

    private void UpdateProfile() {
        String setFirstName = fnInput.getText().toString();
        String setLastName = lnInput.getText().toString();
        String setUserNumber = phInput.getText().toString();

        if(TextUtils.isEmpty(setFirstName)){
            Toast.makeText(this, "Please write your First Name", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(setLastName)){
            Toast.makeText(this, "Please write your Last Name", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(setUserNumber)){
            Toast.makeText(this, "Please write your Number", Toast.LENGTH_SHORT).show();
        }else{ // if all the fields are not empty then we will send this data to the FireBase database by using HashMap
            HashMap<String,String> profileMap = new HashMap<>();
            profileMap.put("uid",currentUserID);
            profileMap.put("fname",setFirstName);
            profileMap.put("lname",setLastName);
            profileMap.put("number",setUserNumber);

            RootRef.child("Users").child(currentUserID).setValue(profileMap)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                SendUserToMainActivity();
                                Toast.makeText(ProfileActivity.this, "Profile update successfully...!", Toast.LENGTH_SHORT).show();
                            }else{// if any Error occure
                                String message = task.getException().toString();
                                Toast.makeText(ProfileActivity.this, "Error: "+ message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(ProfileActivity.this, MainActivity.class);

        // this will stop the user to get again the PhoneLoginActivity when user press the back button
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish(); // part of addFlags line
    }
}