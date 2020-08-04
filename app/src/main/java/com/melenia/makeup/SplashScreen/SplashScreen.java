package com.melenia.makeup.SplashScreen;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.melenia.makeup.Login.LoginActivity;
import com.melenia.makeup.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;

    ImageView logo, dev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setStatusBarColor(getResources().getColor(R.color.putih));

        logo = findViewById(R.id.logoApp);
        dev = findViewById(R.id.logoDev);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this, SplashScreen.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(home);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
