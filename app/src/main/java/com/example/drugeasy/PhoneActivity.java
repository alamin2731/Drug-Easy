package com.example.drugeasy;

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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneActivity extends AppCompatActivity {
    private FirebaseAuth mAuth; //'mAuh' a variable of Firebase auth class
    private EditText editPhoneNumber, editOTP; //input variable
    private Button generateOtpButton, verifyOtpButton;
    private String verificationID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        mAuth = FirebaseAuth.getInstance();
        editPhoneNumber = findViewById(R.id.editTextPhone);
        editOTP = findViewById(R.id.editTextOpt);
        generateOtpButton = findViewById(R.id.genarateOtpButton);
        verifyOtpButton = findViewById(R.id.verifyOtpButton);
        generateOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPhoneNumber.setVisibility(View.GONE);
                generateOtpButton.setVisibility(View.GONE);
                editOTP.setVisibility(View.VISIBLE);
                verifyOtpButton.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(editPhoneNumber.getText().toString())) {
                    Toast.makeText(PhoneActivity.this, "Please enter valid phone number", Toast.LENGTH_SHORT).show();
                } else {
                    String phone = "+880" + editPhoneNumber.getText().toString();
                    sendVerificationCode(phone);
                }
            }
        });

        verifyOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editOTP.getText().toString())) {
                    Toast.makeText(PhoneActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    verifyCode(editOTP.getText().toString());
                }
            }
        });
    }

    //checking entered code correct or not
    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(PhoneActivity.this, LandingActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(PhoneActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //getting otp
    private void sendVerificationCode(String number) {
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth).setPhoneNumber(number).setTimeout(60L, TimeUnit.SECONDS).setActivity(this).setCallbacks(mCallBack).build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    //callBackMethode
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            // when we receive the OTP it
            // contains a unique id which
            // we are storing in our string
            // which we have already created.
            verificationID = s;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            final String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                editOTP.setText(code);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(PhoneActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID, code);
        signInWithCredential(credential);
    }
}