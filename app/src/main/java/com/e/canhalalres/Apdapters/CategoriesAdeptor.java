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
import com.e.canhalalres.Models.AllCategorys;
import com.e.canhalalres.R;

import java.util.ArrayList;

public class CategoriesAdeptor extends RecyclerView.Adapter<CategoriesAdeptor.MyviewHolder> {

    AllCategorys[] allCategorys;

    public CategoriesAdeptor(AllCategorys[] allCategorys) {
        this.allCategorys=allCategorys;
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
        holder.prices.setText(allCategorys[position].getName());
        Glide.with(holder.item_img.getContext()).load(""+allCategorys[position].getCatImgName())
                .into(holder.item_img);
    }

    @Override
    public int getItemCount() {
        return allCategorys.length;
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
        TextView prices;
        ImageView item_img;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            prices = itemView.findViewById(R.id.price);
            item_img = itemView.findViewById(R.id.item_img);

        }
    }
}
