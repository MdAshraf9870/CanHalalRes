package com.e.canhalalres.Activity.Dashboard;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.e.canhalalres.Activity.Dashboard.HomePage.HomeFragment;
import com.e.canhalalres.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class Dashboard extends AppCompatActivity {
    private FrameLayout dashboard_frame;
    private BottomNavigationView bottomNevigation;
    private Fragment temp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_dashboard);
        bottomNevigation = findViewById(R.id.bottomNevigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_frame, new HomeFragment()).commit();
        bottomNevigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homeN:
                    temp = new HomeFragment();
                    break;
                case R.id.coursesN:
//                    temp = new CouressPageFragment();
                    break;
                case R.id.accountN:
//                    temp = new AccountFragment();
                    break;
                case R.id.faq:
//                    temp = new FaqChooseTypeFragment();

            }
            try {

                getSupportFragmentManager().beginTransaction().replace(R.id.dashboard_frame, Objects.requireNonNull(temp)).commit();
            }catch (Exception ignored){

            }

            return true;
        });

    }
}