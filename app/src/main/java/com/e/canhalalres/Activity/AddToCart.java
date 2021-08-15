package com.e.canhalalres.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.e.canhalalres.Models.RestaurantMenuListItemModel;
import com.e.canhalalres.R;

import java.util.ArrayList;

public class AddToCart extends AppCompatActivity {

    String id, name, price;
    private TextView user_name, txtdollor,item_countity,total_prince;
    private ImageButton item_minus,item_plus;
    ArrayList<String> arrayList;
    int prices,countity=1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        Intent intent = getIntent();
        user_name = findViewById(R.id.user_name);
        txtdollor = findViewById(R.id.txtdollor);
        item_countity = findViewById(R.id.item_countity);
        item_minus = findViewById(R.id.item_minus);
        item_plus = findViewById(R.id.item_plus);
        total_prince = findViewById(R.id.total_prince);
        try {
            id = intent.getStringExtra("id");
            name = intent.getStringExtra("name");
            price = intent.getStringExtra("price");
            user_name.setText(name);
            txtdollor.setText("$"+price);
            prices=Integer.parseInt(price);
            total_prince.setText("$"+price);
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        }

        item_countity.setText("1");
        item_plus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                countity++;
                prices=(prices+Integer.parseInt(price));
                total_prince.setText("$"+prices);
                item_countity.setText(String.valueOf(countity));

            }
        });
        item_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countity !=1){
                    countity--;
                    prices=(prices-Integer.parseInt(price));
                    total_prince.setText("$"+prices);
                    item_countity.setText(String.valueOf(countity));
                }

            }
        });

    }
}
