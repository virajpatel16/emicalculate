package com.example.emicalculate;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class DetailsActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
    }

    private void initView() {
        tabLayout = findViewById(R.id.tabs);
        replaceFragment1(new MonthlyDetails());
        setupTabLayout();
        bindWidgetsWithAnEvent();
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               finish();
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void setupTabLayout() {
        TabLayout tabLayout2 = tabLayout;
        tabLayout2.addTab(tabLayout2.newTab().setText("Month"), true);
        TabLayout tabLayout3 = tabLayout;
        tabLayout3.addTab(tabLayout3.newTab().setText("Year"));

    }

    private void bindWidgetsWithAnEvent() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                setCurrentTabFragment(tab.getPosition());
            }
        });
    }

    public void setCurrentTabFragment(int i) {
        if (i == 0) {
            replaceFragment1(new MonthlyDetails());
        } else if (i == 1) {
            replaceFragment1(new YearlyDetails());
        }
    }

    public void replaceFragment1(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.container, fragment);
        beginTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}