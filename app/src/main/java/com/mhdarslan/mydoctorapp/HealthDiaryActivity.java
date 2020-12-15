package com.mhdarslan.mydoctorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class HealthDiaryActivity extends AppCompatActivity {

    private Button homeDiaryUpdateBtn;
    private EditText homeDiaryInput;
    private String currentUserID;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_diary);

        // Title of the activity
        getSupportActionBar().setTitle("Home Diary");

        // Initialization
        mAuth= FirebaseAuth.getInstance();
        currentUserID=mAuth.getCurrentUser().getUid();
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.keepSynced(true);

        homeDiaryInput = findViewById(R.id.homeDiaryInput);
        homeDiaryUpdateBtn = findViewById(R.id.homeDiaryUpdateBtn);

        homeDiaryUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateNote();
            }
        });

        // Retrieve Note Info
        RetrieveNoteInfo();



    }

    private void RetrieveNoteInfo() {
        RootRef.child("Notes").child(currentUserID)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if((dataSnapshot.exists()) && (dataSnapshot.hasChild("note"))){ // if user is updated his Note then

                            String retrieveDiaryNote = dataSnapshot.child("note").getValue().toString();

                            // retrieveUserName will be shown to userName EditText again
                            homeDiaryInput.setText(retrieveDiaryNote);

                        }else{ // if none of these exist
                            Toast.makeText(HealthDiaryActivity.this, "Please update your information...!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
    }

    private void UpdateNote() {
        String diaryNote = homeDiaryInput.getText().toString();

        if(TextUtils.isEmpty(diaryNote)){
            Toast.makeText(this, "Please write your Note first.", Toast.LENGTH_SHORT).show();
        }else{ // if all the fields are not empty then we will send this data to the FireBase database by using HashMap
            HashMap<String,String> diaryNoteMap = new HashMap<>();
            diaryNoteMap.put("uid",currentUserID);
            diaryNoteMap.put("note",diaryNote);

            RootRef.child("Notes").child(currentUserID).setValue(diaryNoteMap)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                SendUserToMainActivity();
                                Toast.makeText(HealthDiaryActivity.this, "Note update successfully...!", Toast.LENGTH_SHORT).show();
                            }else{// if any Error occure
                                String message = task.getException().toString();
                                Toast.makeText(HealthDiaryActivity.this, "Error: "+ message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(HealthDiaryActivity.this, MainActivity.class);

        // this will stop the user to get again the PhoneLoginActivity when user press the back button
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish(); // part of addFlags line
    }
}