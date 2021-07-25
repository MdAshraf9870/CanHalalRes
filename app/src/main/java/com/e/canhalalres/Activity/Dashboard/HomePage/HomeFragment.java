package com.e.canhalalres.Activity.Dashboard.HomePage;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.e.canhalalres.Activity.Registration;
import com.e.canhalalres.Apdapters.CategoriesAdeptor;
import com.e.canhalalres.Apdapters.RestaurantsAdaptor;
import com.e.canhalalres.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class HomeFragment extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

//        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.delivery_tab));
//        tabLayout.addTab(tabLayout.newTab().setText("Delivery").setIcon(R.drawable.ic_delivery_man));
//        tabLayout.addTab(tabLayout.newTab().setText("Pickup").setIcon(R.drawable.ic_relaxing_walk));
//
//        tabLayout.setTabIconTint(ColorStateList.valueOf(getResources().getColor(R.color.Red)));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        CoursesAdapter coursesAdapter = new CoursesAdapter(requireActivity()
                .getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(coursesAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }


    public static class CoursesAdapter extends FragmentStatePagerAdapter {
        int tabcout;

        public CoursesAdapter(FragmentManager fm, int behavior) {

            super(fm, behavior);
            this.tabcout = behavior;

        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new DeliveryPageFragment();
                case 1:
                    return new PickupPageFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return tabcout;

        }
    }

}
