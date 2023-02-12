package com.vaishu.oxfordcollege;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.internal.InternalTokenProvider;

public class registerActivity extends AppCompatActivity {

    EditText RegEmail;
    EditText RegPassword;
    Button btnRegister;
    TextView LoginHere;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        RegEmail = findViewById(R.id.RegEmail);
        RegPassword = findViewById(R.id.password);
        btnRegister = findViewById(R.id.RegisterBtn);
        LoginHere =findViewById(R.id.LoginHere);

        firebaseAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view -> {
            createUser();
        });
        LoginHere.setOnClickListener(view ->{
            startActivity(new Intent(registerActivity.this,loginActivity.class));
        });
    }
    private void createUser(){
        String email = RegEmail.getText().toString();
        String password = RegPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            RegEmail.setError("Email cannot be empty");
            RegPassword.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            RegEmail.setError("password cannot be empty");
            RegPassword.requestFocus();
        }else {
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(registerActivity.this, "user registered successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(registerActivity.this,loginActivity.class));
                    }else{
                        Toast.makeText(registerActivity.this, "Registration error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
