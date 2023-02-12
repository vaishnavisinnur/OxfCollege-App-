package com.vaishu.oxfordcollege;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {

    private Button ForgotBtn;
    private EditText txtEmail;
    private String email;
    private FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        auth=FirebaseAuth.getInstance();

        txtEmail=findViewById(R.id.forEmail);
        ForgotBtn=findViewById(R.id.forgotBtn);


        ForgotBtn.setOnClickListener(view -> {
            validateData();
        });
    }

    private void validateData() {
        email=txtEmail.getText().toString();
        if(email.isEmpty()){
            txtEmail.setError("required");
        }else{
            forgotPass();
        }
    }

    private void forgotPass() {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(forgotPassword.this, "check your email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(forgotPassword.this,loginActivity.class));
                            finish();
                        }else{
                            Toast.makeText(forgotPassword.this, "Error" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}











