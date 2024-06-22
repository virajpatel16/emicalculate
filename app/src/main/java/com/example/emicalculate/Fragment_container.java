package com.example.emicalculate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Fragment_container extends AppCompatActivity {

    int checkin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        if (getIntent().getExtras() != null) {
            checkin = getIntent().getIntExtra("dailycheck", 1);
            switch (checkin) {
                case 101:


                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EMICalculateFragment()).commit();
                    break;
                case 102:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoanCompareFragment()).commit();
                    break;
                case 103:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Intraday_trading()).commit();
                    break;
                case 104:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Delivery_trading()).commit();
                    break;
                case 105:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Future_trading()).commit();
                    break;
                case 106:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Option_trading()).commit();
                    break;
                case 107:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Gst_calculate()).commit();
                    break;
                case 108:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Vat_calculate()).commit();
                    break;
            }
        }

    }


}