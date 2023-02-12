package com.vaishu.oxfordcollege;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class notes extends AppCompatActivity implements View.OnClickListener {


    Button Bca1stSem;
    Button Bca2ndSem;
    Button Bca3rdSem;
    Button Bca4thSem;
    Button Bca5thSem;
    Button Bca6thSem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Bca1stSem = findViewById(R.id.BCA1stSem);
        Bca2ndSem = findViewById(R.id.BCA2ndSem);
        Bca3rdSem = findViewById(R.id.BCA3rdSem);
        Bca4thSem = findViewById(R.id.BCA4thSem);
        Bca5thSem = findViewById(R.id.BCA5thSem);
        Bca6thSem = findViewById(R.id.BCA6thSem);

        Bca1stSem.setOnClickListener(this);
        Bca2ndSem.setOnClickListener(this);
        Bca3rdSem.setOnClickListener(this);
        Bca4thSem.setOnClickListener(this);
        Bca5thSem.setOnClickListener(this);
        Bca6thSem.setOnClickListener(this);
    }




     @Override
     public void onClick(View v) {
      Intent i;
                switch (v.getId()) {
       case R.id.BCA1stSem:
           gotoUrl("https://drive.google.com/drive/folders/1LNFUdN5KrFbOYNCPzv-zjJgoIlBPF8oq?usp=share_link");
           break;
           case R.id.BCA2ndSem:
           gotoUrl("https://drive.google.com/drive/folders/1Iov0AwHBAdDxEnoMXoR2Lu03O6VTWaa-?usp=share_link");
           break;
           case R.id.BCA3rdSem:
           gotoUrl("https://drive.google.com/drive/folders/12HgnAm9-YjQymoGCaRLg9pYm8yNseoIa?usp=share_link");
           break;
           case R.id.BCA4thSem:
           gotoUrl("https://drive.google.com/drive/folders/1YxH16hEHdv1DtHRn1VizD_D_FCeEotIB?usp=share_link");
           break;
           case R.id.BCA5thSem:
           gotoUrl("https://drive.google.com/drive/folders/10z6Msx8kfG-AdnfcFb5SoPRhXAq0Zh9f?usp=share_link");
            break;
           case R.id.BCA6thSem:
           gotoUrl("https://drive.google.com/drive/folders/1CskwsrNQBWaUcx9PkxmIiLqnHD4nkaCB?usp=share_link");
          default:
           break;

                }
    }

           public void gotoUrl(String s) {
           try {
              Uri uri = Uri.parse(s);
              Intent intent = new Intent(Intent.ACTION_VIEW);
              intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           //Setting package to let android know which app should open this link.
                 intent.setPackage("com.android.chrome");
                 intent.setData(uri);
                 startActivity(intent);
           }
           catch (ActivityNotFoundException e) {
                    Toast.makeText(notes.this, "please select a browse to open link", Toast.LENGTH_SHORT).show();
           //Starting another activity but this time not hardcoding the package.
               Uri uri = Uri.parse(s);
               Intent intent = new Intent(Intent.ACTION_VIEW);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.setData(uri);
               startActivity(intent);
            }
           catch (Exception e) {
               Toast.makeText(notes.this, "no website linked", Toast.LENGTH_SHORT).show();
 }
   }
 }





















































//    Button BCA1stSem;
//    Button BCA2ndSem;
//    Button BCA3rdSem;
//    Button BCA4thSem;
//    Button BCA5thSem;
//    Button BCA6thSem;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notes);
//
//
//        BCA1stSem = findViewById(R.id.BCA1stSem);
//        BCA2ndSem = findViewById(R.id.BCA2ndSem);
//        BCA3rdSem = findViewById(R.id.BCA3rdSem);
//        BCA4thSem = findViewById(R.id.BCA4thSem);
//        BCA5thSem = findViewById(R.id.BCA5thSem);
//        BCA6thSem = findViewById(R.id.BCA6thSem);
//
//        BCA1stSem.setOnClickListener(this);
//        BCA2ndSem.setOnClickListener(this);
//        BCA3rdSem.setOnClickListener(this);
//        BCA4thSem.setOnClickListener(this);
//        BCA5thSem.setOnClickListener(this);
//        BCA6thSem.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        Intent i;
//
//        switch (v.getId()) {
//            case R.id.BCA1stSem:
//                String url = ""
//                break;
//            case R.id.BCA2ndSem:
//                String url2 = "https://drive.google.com/drive/folders/1LNFUdN5KrFbOYNCPzv-zjJgoIlBPF8oq?usp=share_link";
//                 i=(Uri.parse(url2));
//                 startActivity(i);
//                break;
//            case R.id.BCA3rdSem:
//                gotoUrl("https://drive.google.com/drive/folders/12HgnAm9-YjQymoGCaRLg9pYm8yNseoIa?usp=share_link");
//                break;
//            case R.id.BCA4thSem:
//                gotoUrl("https://drive.google.com/drive/folders/1YxH16hEHdv1DtHRn1VizD_D_FCeEotIB?usp=share_link");
//                 break;
//            case R.id.BCA5thSem:
//                gotoUrl("https://drive.google.com/drive/folders/10z6Msx8kfG-AdnfcFb5SoPRhXAq0Zh9f?usp=share_link");
//                 break;
//            case R.id.BCA6thSem:
//                gotoUrl("https://drive.google.com/drive/folders/1CskwsrNQBWaUcx9PkxmIiLqnHD4nkaCB?usp=share_link");
//
//        }
//    }
//
//    private void gotoUrl(String s) {
//        Uri uri = Uri.parse(s);
//        startActivity(new Intent(Intent.ACTION_VIEW, uri));
//    }
//}