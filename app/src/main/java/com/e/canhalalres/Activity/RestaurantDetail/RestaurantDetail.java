package com.e.canhalalres.Activity.RestaurantDetail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.e.canhalalres.Apdapters.RestaurantsAdaptor;
import com.e.canhalalres.Models.ModelGetRestaurantsNearby;
import com.e.canhalalres.Models.RestaurantMenuListModel;
import com.e.canhalalres.R;
import com.e.canhalalres.Url.Url;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class RestaurantDetail extends AppCompatActivity {
    private RecyclerView categories_rvList;

    private String RestaurantIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            Window w = getWindow(); // in Activity's onCreate() for instance
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            categories_rvList = findViewById(R.id.categories_rvList);
            getSupportFragmentManager().beginTransaction().replace(R.id.menuItemList_frame,new ManuItemListFragment()).commit();
            Intent intent =getIntent();
            try {

                if (intent.getStringExtra("idRestaurantDetail" )!= null) {
                    getRestaurantData(intent.getStringExtra("idRestaurantDetail" ));
                }
            }catch (Exception e){

            }

            ArrayList<String> arrayList =new ArrayList();
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            categories_rvList.setLayoutManager(new LinearLayoutManager(RestaurantDetail.this, LinearLayoutManager.HORIZONTAL, false));

        }

    }

    private void getRestaurantData(String idRestaurantDetail) {
        try {
            StringRequest request = new StringRequest(Request.Method.GET, Url.Get_All_CatBy_RestId+idRestaurantDetail,
                    response -> {
                        if (response != null) {
                            GsonBuilder gsonBuilder = new GsonBuilder();
                            Gson gson = gsonBuilder.create();
                            RestaurantMenuListModel[] restaurantMenuListModel = gson.fromJson(response, RestaurantMenuListModel[].class);
                            categories_rvList.setAdapter(new CategoriesListApdaptor(restaurantMenuListModel,this));

                        }

                    }, (VolleyError volleyError) -> {
                Toast.makeText(this, volleyError.toString(), Toast.LENGTH_SHORT).show();

            }

            ) {

            };
            @SuppressLint("UseRequireInsteadOfGet")
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();

        }
    }
    static class CategoriesListApdaptor extends RecyclerView.Adapter<CategoriesListApdaptor.MyViewholder> {
        AppCompatActivity activity;
        int row_index;
        RestaurantMenuListModel[] restaurantMenuListModel;
        Context context;
        public CategoriesListApdaptor(RestaurantMenuListModel[] restaurantMenuListModel, Context context) {
            this.restaurantMenuListModel=restaurantMenuListModel;
            this.context=context;
        }


        @NonNull
        @Override
        public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item_list, parent, false);
            return new MyViewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
            activity=(AppCompatActivity)context;
        holder.listName.setText(restaurantMenuListModel[position].getName());

            holder.listName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = position ;
                    notifyDataSetChanged();
                }
            });
            if(row_index ==position){
                holder.listName.setTextColor(Color.parseColor("#db212b"));
                holder.manuItemBottomLine.setVisibility(View.VISIBLE);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.menuItemList_frame,new ManuItemListFragment("1")).commit();

            }
            else
            {
                holder.listName.setTextColor(Color.parseColor("#000000"));
                holder.manuItemBottomLine.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount() {
            return restaurantMenuListModel.length;
        }

        public static class MyViewholder extends RecyclerView.ViewHolder {
            TextView listName;
            View manuItemBottomLine;

            public MyViewholder(@NonNull View itemView) {
                super(itemView);
                listName = itemView.findViewById(R.id.listName);
                manuItemBottomLine = itemView.findViewById(R.id.manuItemBottomLine);
            }
        }
    }
}