package com.example.drugeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    public void createAccount(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    public void passwordReset(View view) {
        startActivity(new Intent(LoginActivity.this, ResetActivity.class));
    }
    public void phonee(View view) {
        startActivity(new Intent(LoginActivity.this, PhoneActivity.class));
    }


    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, LandingActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
setTitle("Login");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        btnSignIn = (Button) findViewById(R.id.button2);

        inputEmail = (EditText) findViewById(R.id.getTextEmailAddress);
        inputPassword = (EditText) findViewById(R.id.getTextPassword);
        // progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
//                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                inputPassword.setError("Password too short, enter minimum 6 characters!");
                            } else {
                                Toast.makeText(LoginActivity.this, "Authentication failed, check your email and password or sign up", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(LoginActivity.this, LandingActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        });
    }
}