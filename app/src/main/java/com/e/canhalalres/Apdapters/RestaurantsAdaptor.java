package com.e.canhalalres.Apdapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.canhalalres.Models.ModelGetRestaurantsNearby;
import com.e.canhalalres.Models.modelGetCategories;
import com.e.canhalalres.R;

public class RestaurantsAdaptor  extends RecyclerView.Adapter<RestaurantsAdaptor.MyviewHolder> {


    ModelGetRestaurantsNearby[] modelGetRestaurantsNearbies;

    public RestaurantsAdaptor(ModelGetRestaurantsNearby[] modelGetRestaurantsNearbies) {
        this.modelGetRestaurantsNearbies = modelGetRestaurantsNearbies;
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
        holder.prices.setText(modelGetRestaurantsNearbies[position].getName());
        String name= modelGetRestaurantsNearbies[position].getName();
        Toast.makeText(holder.prices.getContext(), ""+name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return modelGetRestaurantsNearbies.length;
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
        TextView prices;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            prices = itemView.findViewById(R.id.price);

        }
    }
}
