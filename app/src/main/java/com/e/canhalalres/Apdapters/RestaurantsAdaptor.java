package com.e.canhalalres.Apdapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.e.canhalalres.Activity.Dashboard.Dashboard;
import com.e.canhalalres.Activity.Login;
import com.e.canhalalres.Activity.RestaurantDetail.RestaurantDetail;
import com.e.canhalalres.Models.ModelGetRestaurantsNearby;
import com.e.canhalalres.Models.modelGetCategories;
import com.e.canhalalres.R;

public class RestaurantsAdaptor  extends RecyclerView.Adapter<RestaurantsAdaptor.MyviewHolder> {
        AppCompatActivity activity;

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
        activity=(AppCompatActivity)holder.prices.getContext();
        holder.prices.setText(modelGetRestaurantsNearbies[position].getName());
        String name= modelGetRestaurantsNearbies[position].getName();

        holder.restaurants_nearby_lsit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RestaurantDetail.class);
               intent.putExtra("idRestaurantDetail","1");
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelGetRestaurantsNearbies.length;
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
        TextView prices;
        LinearLayout restaurants_nearby_lsit;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            prices = itemView.findViewById(R.id.price);
            restaurants_nearby_lsit = itemView.findViewById(R.id.restaurants_nearby_lsit);

        }
    }
}
