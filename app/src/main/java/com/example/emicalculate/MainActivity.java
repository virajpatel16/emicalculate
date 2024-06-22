package com.example.emicalculate;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout emicalculate, loancompare, intraday, delivery, feture, option, gst, vat;
    public static int decimalPlace;
    public static int numberFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emicalculate = findViewById(R.id.emicalculate);
        loancompare = findViewById(R.id.loancompare);
        intraday = findViewById(R.id.intraday);
        delivery = findViewById(R.id.delivery);
        feture = findViewById(R.id.feture);
        option = findViewById(R.id.option);
        gst = findViewById(R.id.gst);
        vat = findViewById(R.id.vat);


        emicalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load Fragment1 into container_fragment1
                Intent intent = new Intent(MainActivity.this, Fragment_container.class);
                intent.putExtra("dailycheck", 101);

                startActivity(intent);
            }
        });

        loancompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fragment_container.class);
                intent.putExtra("dailycheck", 102);

                startActivity(intent);
            }
        });
        intraday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fragment_container.class);
                intent.putExtra("dailycheck", 103);

                startActivity(intent);
            }
        });
        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fragment_container.class);
                intent.putExtra("dailycheck", 104);

                startActivity(intent);
            }
        });
        feture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fragment_container.class);
                intent.putExtra("dailycheck", 105);

                startActivity(intent);
            }
        });
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fragment_container.class);
                intent.putExtra("dailycheck", 106);

                startActivity(intent);
            }
        });
        gst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fragment_container.class);
                intent.putExtra("dailycheck", 107);

                startActivity(intent);
            }
        });
        vat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Fragment_container.class);
                intent.putExtra("dailycheck", 108);

                startActivity(intent);
            }
        });
    }


        @SuppressLint("MissingSuperCall")
        @Override
        public void onBackPressed() {

            final AlertDialog.Builder alert=new AlertDialog.Builder(this);
            View view=getLayoutInflater().inflate(R.layout.exit_dialog,null);
            alert.setView(view);
            final AlertDialog dialog=alert.create();
            dialog.setCancelable(false);
            view.findViewById(R.id.BTN_YES).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    finishAffinity();
                    // finishAndRemoveTask();
                }
            });
            view.findViewById(R.id.BTN_NO).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.show();
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();

        }



    }