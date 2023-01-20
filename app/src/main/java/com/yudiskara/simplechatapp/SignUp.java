package com.yudiskara.simplechatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnSignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        edtName = findViewById(R.id.edit_name);
        edtEmail = findViewById(R.id.edit_email);
        edtPassword = findViewById(R.id.edit_password);
        btnSignUp = findViewById(R.id.buttonSignUp);

        btnSignUp.setOnClickListener(view -> {
            String email = edtEmail.toString();
            String password = edtPassword.toString();

            signUp(email, password);
        });
    }

    private boolean signUp(String email, String pass){
        //logic untuk sign in

    }
}