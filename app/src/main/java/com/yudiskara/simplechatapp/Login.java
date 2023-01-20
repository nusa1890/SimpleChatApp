package com.yudiskara.simplechatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnSignUp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        edtEmail = findViewById(R.id.edit_email);
        edtPassword = findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.buttonLogin);
        btnSignUp = findViewById(R.id.buttonSignUp);

        btnSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, SignUp.class);
            startActivity(intent);
        });
//        Fungsi ini adalah fungsi diatas tanpa menggunakan lambda
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent btnSignUp = new Intent(Login.this, SignUp.class);
//                startActivity(btnSignUp);
//            }
//        });
        btnLogin.setOnClickListener(view -> {
            String email = edtEmail.toString();
            String password = edtPassword.toString();

            login(email, password);
        });

    }
    private boolean login(String email, String pass){
        //logic untuk login
    }

}