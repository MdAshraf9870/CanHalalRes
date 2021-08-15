package com.e.canhalalres.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.canhalalres.Apdapters.CardsAdapter;
import com.e.canhalalres.Models.CardsModel;
import com.e.canhalalres.R;

public class MyCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cards);

        CardsModel[] myListData = new CardsModel[] {
                new CardsModel("HDFC Bank Debit Card *****0987", "Salike tarique","Expirys 01/25"),
                new CardsModel("HDFC Bank Debit Card *****0987", "Salike tarique","Expirys 01/25"),
                new CardsModel("HDFC Bank Debit Card *****0987", "Salike tarique","Expirys 01/25"),
                new CardsModel("HDFC Bank Debit Card *****0987", "Salike tarique","Expirys 01/25"),
                new CardsModel("HDFC Bank Debit Card *****0987", "Salike tarique","Expirys 01/25"),
                new CardsModel("HDFC Bank Debit Card *****0987", "Salike tarique","Expirys 01/25"),


        };


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recylerCards);
        CardsAdapter adapter = new CardsAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    }
