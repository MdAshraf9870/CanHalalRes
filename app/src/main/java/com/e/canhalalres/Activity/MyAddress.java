package com.e.canhalalres.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.e.canhalalres.Apdapters.AddressAdapter;
import com.e.canhalalres.Models.AddressModel;
import com.e.canhalalres.R;

public class MyAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        AddressModel[] myListData = new AddressModel[] {
                new AddressModel("Salik Tarique", "2806 Montague Rd, Galiano Island,BC V0N 1PO, Canada","Phone Number: 9312001322"),
                new AddressModel("Salik Tarique", "2806 Montague Rd, Galiano Island,BC V0N 1PO, Canada","Phone Number: 9312001322"),
                new AddressModel("Salik Tarique", "2806 Montague Rd, Galiano Island,BC V0N 1PO, Canada","Phone Number: 9312001322"),
                new AddressModel("Salik Tarique", "2806 Montague Rd, Galiano Island,BC V0N 1PO, Canada","Phone Number: 9312001322"),
                new AddressModel("Salik Tarique", "2806 Montague Rd, Galiano Island,BC V0N 1PO, Canada","Phone Number: 9312001322"),
                new AddressModel("Salik Tarique", "2806 Montague Rd, Galiano Island,BC V0N 1PO, Canada","Phone Number: 9312001322"),


        };


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerAdress);
        AddressAdapter adapter = new AddressAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}