package com.example.android_count;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class SplashIni extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ini);
        Intent principal = new Intent(this , MainActivity.class);

        TextView contador = (TextView)findViewById(R.id.text1);
        long total = 6000;


        new CountDownTimer(total, 1000) {

            public void onTick(long millisUntilFinished) {
                contador.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                startActivity(principal);
                finish();
            }
        }.start();


    }
}