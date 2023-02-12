package com.vaishu.oxfordcollege;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {


    EditText LoginEmail;
    EditText LoginPassword;
    boolean passwordVisible;
    Button btnLogin;

    TextView RegisterHere,ForgotPassword;

    FirebaseAuth firebaseAuth;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginEmail=findViewById(R.id.Email);
        LoginPassword=findViewById(R.id.password);
        RegisterHere=findViewById(R.id.RegisterHere);
        ForgotPassword=findViewById(R.id.forgotPass);
        btnLogin=findViewById(R.id.LoginBtn);

        firebaseAuth=FirebaseAuth.getInstance();


        LoginPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=LoginPassword.getRight()-LoginPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=LoginPassword.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            LoginPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_off_24,0);
                            // for hide password
                            LoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else{
                            //set drawable image here
                            LoginPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_24,0);
                            // for hide password
                            LoginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        LoginPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        btnLogin.setOnClickListener(view ->{
            loginUser();
        });

        RegisterHere.setOnClickListener(view ->{
            startActivity(new Intent(loginActivity.this,registerActivity.class));

        });
        ForgotPassword.setOnClickListener(view -> {
            startActivity(new Intent(loginActivity.this, forgotPassword.class));
        });
    }

    private void loginUser(){
        String email = LoginEmail.getText().toString();
        String password = LoginPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
          //  LoginEmail.setError("Email cannot be empty");
            LoginEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            LoginPassword.setError("password cannot be empty");
            LoginPassword.requestFocus();
        }else {
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                  if(task.isSuccessful()){
                      Toast.makeText(loginActivity.this, "user logged in successful", Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(loginActivity.this,MainActivity.class));

                  }else{
                      Toast.makeText(loginActivity.this, "Login Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                  }
                }
            });
        }

    }
}















































//  LoginPassword.setOnTouchListener(new View.OnTouchListener() {
//@Override
//public boolean onTouch(View v, MotionEvent event) {
//final int Right=2;
//        if(event.getAction()==MotionEvent.ACTION_UP){
//        if(event.getRawX()>=LoginPassword.getRight()-LoginPassword.getCompoundDrawables()[Right].getBounds().width()){
//        int selection=LoginPassword.getSelectionEnd();
//        if(passwordVisible){
//        //set drawable image here
//        LoginPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_off_24,0);
//        // for hide password
//        LoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
//        passwordVisible=false;
//        }else{
//        //set drawable image here
//        LoginPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_24,0);
//        // for hide password
//        LoginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//        passwordVisible=true;
//        }
//        LoginPassword.setSelection(selection);
//        return true;
//        }
//        }
//        return false;
//        }
//        });
//
//
//
//
//
//
