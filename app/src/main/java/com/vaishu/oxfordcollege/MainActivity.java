package com.vaishu.oxfordcollege;

import android.content.Intent;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;
import androidx.cardview.widget.CardView;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth firebaseAuth;

    CardView cardWebsite;
    CardView cardERPLogin;
    CardView cardNotes;
    CardView cardQuestion_papers;
    CardView cardSyllabus;
    CardView cardNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        cardWebsite = findViewById(R.id.cardWebsite);
        cardERPLogin = findViewById(R.id.cardERPLogin);
        cardNotes = findViewById(R.id.cardNotes);
        cardQuestion_papers = findViewById(R.id.cardQuestion_paper);
        cardSyllabus = findViewById(R.id.cardSyllabus);
        cardNotification = findViewById(R.id.cardNotification);


        //Adding click listener to the cards
        cardWebsite.setOnClickListener(this);
        cardERPLogin.setOnClickListener(this);
        cardNotes.setOnClickListener(this);
        cardQuestion_papers.setOnClickListener(this);
        cardSyllabus.setOnClickListener(this);
        cardNotification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.cardWebsite:
                gotoUrl("https://www.oxfordcollege.edu.in/");
                break;
            case R.id.cardERPLogin:
                i = new Intent(this, erpLogin.class);
                startActivity(i);
                break;
            case R.id.cardNotes:
                i = new Intent(this, notes.class);
                startActivity(i);
                break;
            case R.id.cardQuestion_paper:
                i = new Intent(this, question_papers.class);
                startActivity(i);
                break;
            case R.id.cardSyllabus:
                i = new Intent(this, syllabus.class);
                startActivity(i);
                break;
            case R.id.cardNotification:
                i = new Intent(this, notification.class);
                startActivity(i);
                break;
            default:
                break;


        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null) {
            startActivity(new Intent(MainActivity.this, loginActivity.class));
        }
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}

