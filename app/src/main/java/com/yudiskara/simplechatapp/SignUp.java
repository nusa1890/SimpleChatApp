package com.yudiskara.simplechatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUp extends AppCompatActivity {
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnSignUp;
    private FirebaseAuth mAuth;
    public DatabaseReference mDbRef;

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
            String name = edtName.getText().toString();
            String email = edtEmail.getText().toString();
            String password = edtPassword.getText().toString();

            signUp(name, email, password);
        });
    }

    private void signUp(String name, String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener( this, task -> {
                    if (task.isSuccessful()) {
                        addUserToDatabase(name, email, Objects.requireNonNull(mAuth.getCurrentUser()).getUid() );
                        Intent intent = new Intent(SignUp.this, MainActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(SignUp.this, "Some error occurred", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void addUserToDatabase(String name, String email, String uid){
        mDbRef = FirebaseDatabase.getInstance().getReference();
        System.out.println(FirebaseDatabase.getInstance().getReference());
        mDbRef.child("user").child(uid).setValue(new User(name, email, uid));


    }
}