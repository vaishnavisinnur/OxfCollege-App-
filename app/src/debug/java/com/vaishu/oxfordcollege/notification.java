package com.vaishu.oxfordcollege;

import static com.vaishu.oxfordcollege.R.id.ClickMe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class notification extends AppCompatActivity implements  View.OnClickListener{

    Button ClickMe;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ClickMe=findViewById(R.id.ClickMe);
        ClickMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.ClickMe:
                gotoUrl("https://drive.google.com/drive/folders/1IrjVuHuK_0I98ZwcAzbDUqSdis5LJI1H?usp=share_link");
                break;
            default:
                break;
    }
}

    private void gotoUrl(String s) {
     try {
        Uri uri = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Setting package to let android know which app should open this link.
        intent.setPackage("com.android.chrome");
        intent.setData(uri);
        startActivity(intent);
    }
           catch (
    ActivityNotFoundException e) {
               Toast.makeText(notification.this, "please select a browse to open link", Toast.LENGTH_SHORT).show();
        //Starting another activity but this time not hardcoding the package.
        Uri uri = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(uri);
        startActivity(intent);
    }
           catch (Exception e) {
        Toast.makeText(notification.this, "no website linked", Toast.LENGTH_SHORT).show();
    }
}
 }