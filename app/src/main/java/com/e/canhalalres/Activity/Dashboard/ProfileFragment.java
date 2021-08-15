package com.e.canhalalres.Activity.Dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.e.canhalalres.Activity.MyAddress;
import com.e.canhalalres.Activity.MyCards;
import com.e.canhalalres.R;


public class ProfileFragment extends Fragment {
    LinearLayout linear_myOrders,linear_myAddress,my_card_payment;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        linear_myOrders = view.findViewById(R.id.linear_myOrder);
        my_card_payment = view.findViewById(R.id.my_card_payment);
        linear_myAddress = view.findViewById(R.id.linear_myAddress);

        linear_myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        linear_myAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyAddress.class);
                startActivity(intent);
            }
        });

        my_card_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyCards.class);
                startActivity(intent);
            }
        });

        return view;
    }
}