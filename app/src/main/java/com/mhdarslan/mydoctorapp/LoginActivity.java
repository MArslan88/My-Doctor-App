package com.mhdarslan.mydoctorapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    private Button SendVerificationCodeButton, VerifyButton;
    private EditText InputPhoneNumber, InputVerificationCode;
    private TextView skipTxt;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private DatabaseReference RootRef;

    private ProgressDialog loadingBar;

    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Title of the activity
        getSupportActionBar().setTitle("Login");

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        RootRef= FirebaseDatabase.getInstance().getReference();

        SendVerificationCodeButton = (Button)findViewById(R.id.send_ver_code_button);
        VerifyButton= (Button)findViewById(R.id.verify_button);
        InputPhoneNumber = (EditText) findViewById(R.id.phone_number_input);
        InputVerificationCode = (EditText) findViewById(R.id.verification_code_input);
        skipTxt = findViewById(R.id.skipTxt);

        // Skip Text clickListener
        skipTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToMainActivity2();
            }
        });

        loadingBar = new ProgressDialog(this);

        SendVerificationCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNumber = InputPhoneNumber.getText().toString().trim();
                if(TextUtils.isEmpty(phoneNumber)){
                    Toast.makeText(LoginActivity.this, "Please enter your phone number...", Toast.LENGTH_SHORT).show();

                }else{
                    loadingBar.setTitle("Phone Verification");
                    loadingBar.setMessage("Please wait, while we are authenticating your phone...");
                    loadingBar.setCanceledOnTouchOutside(false);
                    loadingBar.show();

                    PhoneAuthOptions options =
                            PhoneAuthOptions.newBuilder(mAuth)
                                    .setPhoneNumber(phoneNumber)       // Phone number to verify
                                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                    .setActivity(LoginActivity.this)                 // Activity (for callback binding)
                                    .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
                                    .build();
                    PhoneAuthProvider.verifyPhoneNumber(options);

                }
            }
        });

        VerifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // to hide the button and EditText for number, after sending verification code
                SendVerificationCodeButton.setVisibility(View.INVISIBLE);
                InputPhoneNumber.setVisibility(View.INVISIBLE);

                String verificationCode = InputVerificationCode.getText().toString();
                if(TextUtils.isEmpty(verificationCode)){
                    Toast.makeText(LoginActivity.this, "Please write first.", Toast.LENGTH_SHORT).show();
                }else{
                    loadingBar.setTitle("Verification code");
                    loadingBar.setMessage("Please wait, while we are verifying code...");
                    loadingBar.setCanceledOnTouchOutside(false);
                    loadingBar.show();

                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, verificationCode);
                    signInWithPhoneAuthCredential(credential);

                    if(currentUser !=null){
                        // to add the user id into the Firebase realtime database Users-> Uid
                        String currentUserID = mAuth.getCurrentUser().getUid();
                        RootRef.child("Users").child(currentUserID).setValue("");
                    }else {
//                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
//                        signInWithPhoneAuthCredential(credential);
                    }
                }
            }
        });


        callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                loadingBar.dismiss();
                Toast.makeText(LoginActivity.this, "Please enter valid phone number with your country code.", Toast.LENGTH_SHORT).show();

                Log.w("Error Report", "onVerificationFailed", e);

                // to VISIBLE the button and EditText for number, after sendingFail verification code
                SendVerificationCodeButton.setVisibility(View.VISIBLE);
                InputPhoneNumber.setVisibility(View.VISIBLE);

                // to hide the button and EditText for verify code, after sendingFail verification code
                VerifyButton.setVisibility(View.INVISIBLE);
                InputVerificationCode.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onCodeSent(String verificationId,
                                   PhoneAuthProvider.ForceResendingToken token) {

                // Save verification ID and resending token so we can use them later
                mVerificationId = verificationId;
                mResendToken = token;

                loadingBar.dismiss();
                Toast.makeText(LoginActivity.this, "Code has been sent, check your SMS.", Toast.LENGTH_SHORT).show();

                // to hide the button and EditText for number, after sending verification code
                SendVerificationCodeButton.setVisibility(View.INVISIBLE);
                InputPhoneNumber.setVisibility(View.INVISIBLE);

                // to VISIBLE the button and EditText for verify code, after sending verification code
                VerifyButton.setVisibility(View.VISIBLE);
                InputVerificationCode.setVisibility(View.VISIBLE);
            }
        };
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) { //  it means user provide correct code
                            loadingBar.dismiss();
//                            Toast.makeText(LoginActivity.this, "Congratulations, you're logged in successfully...", Toast.LENGTH_SHORT).show();

                            SendUserToMainActivity();
                        } else {
                            String message = task.getException().toString();
                            Toast.makeText(LoginActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);

        // this will stop the user to get again the PhoneLoginActivity when user press the back button
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        finish(); // part of addFlags line
    }

    private void SendUserToMainActivity2() {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity2.class);
        startActivity(mainIntent);
    }
}