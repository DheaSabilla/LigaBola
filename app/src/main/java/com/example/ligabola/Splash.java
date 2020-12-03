package com.example.ligabola;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class Splash extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.spalshscreen);
            getSupportActionBar().hide();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in = new Intent(Splash.this, ControlClass.class);
                    startActivity(in);
                    finish();
                }
            }, 3000);
        }
    }
