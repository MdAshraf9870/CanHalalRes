package com.e.canhalalres.Apdapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.e.canhalalres.Models.modelGetCategories;
import com.e.canhalalres.R;

public class CategoriesAdeptor extends RecyclerView.Adapter<CategoriesAdeptor.MyviewHolder> {

    modelGetCategories[] allCategories;

    public CategoriesAdeptor(modelGetCategories[] allCategories) {
        this.allCategories = allCategories;
    }



    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new MyviewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        Glide.with(holder.item_img.getContext()).load("http://ccepmt.com"+ allCategories[position].getImgUrl())
                .into(holder.item_img);
        String name= allCategories[position].getName();
        holder.prices.setText(name);
    }

    @Override
    public int getItemCount() {
        return allCategories.length;
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
        TextView prices;
        ImageView item_img;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            prices = itemView.findViewById(R.id.price2);
            item_img = itemView.findViewById(R.id.item_img);

        }
    }
}
