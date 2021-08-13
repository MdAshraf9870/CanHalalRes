 package com.e.canhalalres.Activity.Dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.canhalalres.Activity.MyAddress;
import com.e.canhalalres.Activity.MyCards;
import com.e.canhalalres.R;


public class ProfileFragment extends Fragment {
    TextView txt_myAddress,txt_myCards;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        txt_myAddress = view.findViewById(R.id.txt_myAddress);
        txt_myCards = view.findViewById(R.id.txt_Myorders);

        txt_myAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyAddress.class);
                startActivity(intent);
            }
        });
        txt_myCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyCards.class);
                startActivity(intent);
            }
        });
        return view;
    }
}