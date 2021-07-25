package com.e.canhalalres.Apdapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.canhalalres.Models.AllCategorys;
import com.e.canhalalres.R;

import java.util.ArrayList;

public class RestaurantsAdaptor  extends RecyclerView.Adapter<RestaurantsAdaptor.MyviewHolder> {


    AllCategorys[] allCategorys;

    public RestaurantsAdaptor(AllCategorys[] allCategorys) {
        this.allCategorys=allCategorys;
    }


    @NonNull
    @Override
    public RestaurantsAdaptor.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restauran_list, parent, false);
        return new RestaurantsAdaptor.MyviewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RestaurantsAdaptor.MyviewHolder holder, int position) {
        holder.prices.setText(allCategorys[position].getName());
    }

    @Override
    public int getItemCount() {
        return allCategorys.length;
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
        TextView prices;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            prices = itemView.findViewById(R.id.price);

        }
    }
}
