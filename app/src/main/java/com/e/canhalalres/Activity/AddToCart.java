package com.e.canhalalres.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.e.canhalalres.Models.RestaurantMenuListItemModel;
import com.e.canhalalres.R;
import com.e.canhalalres.Url.Url;
import com.e.canhalalres.Utils.CustomProgressDialog;
import com.e.canhalalres.Utils.CustomVolley;

import java.util.ArrayList;
import java.util.HashMap;

public class AddToCart extends AppCompatActivity {

    String id, name, price;
    private TextView user_name, txtdollor,item_quantity,total_price;
    private ImageButton item_minus,item_plus;
    ArrayList<String> arrayList;
    int prices,countity=1;
    private LinearLayout linear_create;
    Dialog pd;
    public static final String TAG = AddToCart.class.getSimpleName();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        pd = CustomProgressDialog.getInstance().customProgressDialog(AddToCart.this);
        Intent intent = getIntent();
        user_name = findViewById(R.id.user_name);
        txtdollor = findViewById(R.id.txtdollor);
        item_quantity = findViewById(R.id.item_quantity);
        item_minus = findViewById(R.id.item_minus);
        item_plus = findViewById(R.id.item_plus);
        total_price = findViewById(R.id.total_price);
        linear_create = findViewById(R.id.linear_create);
        try {
            id = intent.getStringExtra("id");
            name = intent.getStringExtra("name");
            price = intent.getStringExtra("price");
            user_name.setText(name);
            txtdollor.setText("$"+price);
            prices=Integer.parseInt(price);
            total_price.setText("$"+price);
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
        }

        item_quantity.setText("1");
        item_plus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                countity++;
                prices=(prices+Integer.parseInt(price));
                total_price.setText("$"+prices);
                item_quantity.setText(String.valueOf(countity));

            }
        });
        item_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countity !=1){
                    countity--;
                    prices=(prices-Integer.parseInt(price));
                    total_price.setText("$"+prices);
                    item_quantity.setText(String.valueOf(countity));
                }

            }
        });
        linear_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCartData();
            }
        });

    }

    private void AddCartData() {
        HashMap<String,String> hashMap =  new HashMap<>();
        hashMap.put("menuItemId", id);
        hashMap.put("quantity","1");
        hashMap.put("price", "120");
        hashMap.put("userId", "1");
        if (pd!=null){
            pd.show();
        }
        try {
            CustomVolley.getInstance().postVolley(AddToCart.this, Url.Add_Cart, hashMap, TAG, new CustomVolley.IRequestCallbacks() {
                @Override
                public void onStringResponse(String response) {
                    if (response!=null && !response.isEmpty()){
                        if (pd!=null && pd.isShowing()){
                            pd.dismiss();
                            Toast.makeText(AddToCart.this,
                                    "Your Order Successfully Saved into Cart", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        if (pd!=null && pd.isShowing()){
                            pd.dismiss();
                            Toast.makeText(AddToCart.this,
                                    "Your Order Successfully Saved into Cart", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    if (pd!=null && pd.isShowing()){
                        pd.dismiss();
                        Toast.makeText(AddToCart.this, volleyError.toString(), Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }catch (Exception e){
            if (pd!=null && pd.isShowing()){
                pd.dismiss();
                Toast.makeText(AddToCart.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
