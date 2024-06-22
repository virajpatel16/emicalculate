package com.example.emicalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class Splace_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splace_screen);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity after a delay
                startMainActivity();
            }
        }, 4000); // 2000 milliseconds = 2 seconds

    }


    private void startMainActivity() {
        Intent intent = new Intent(Splace_screen.this, Privacy_police.class);
        startActivity(intent);
        finish(); // Finish the current activity after starting MainActivity
    }
    }
