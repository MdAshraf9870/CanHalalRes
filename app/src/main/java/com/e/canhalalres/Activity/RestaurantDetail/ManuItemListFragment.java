package com.e.canhalalres.Activity.RestaurantDetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.e.canhalalres.Activity.AddToCart;
import com.e.canhalalres.Apdapters.RestaurantsAdaptor;
import com.e.canhalalres.Models.ModelGetRestaurantsNearby;
import com.e.canhalalres.Models.RestaurantMenuListItemModel;
import com.e.canhalalres.R;
import com.e.canhalalres.Url.Url;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Preconditions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;


public class ManuItemListFragment extends Fragment {
   private RecyclerView menuItenLsit;
   private String menuRestIds;

    public ManuItemListFragment() {

    }

    public ManuItemListFragment(String menuRestIds) {
        this.menuRestIds=menuRestIds;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_manu_item_list, container, false);
        menuItenLsit=view.findViewById(R.id.menuItenLsit);
        ArrayList<String> arrayList =new ArrayList();
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");

        if (menuRestIds !=null){
            getRestaurantsNearby(menuRestIds);
        }
        return view;
    }
    private void getRestaurantsNearby(String menuRestIds) {
        try {
            StringRequest request = new StringRequest(Request.Method.GET, Url.Category_Get_Cat_By_Rest+menuRestIds,
                    response -> {
                        if (response != null) {
                            try {
                                int i=0;
                                JSONObject jsonObject=new JSONObject(response);
                                GsonBuilder gsonBuilder = new GsonBuilder();
                                Gson gson = gsonBuilder.create();
                                RestaurantMenuListItemModel[] restaurantMenuListItemModels = gson.fromJson(jsonObject.getString("data"), RestaurantMenuListItemModel[].class);

                                menuItenLsit.setAdapter(new CategoriesListApdaptor(restaurantMenuListItemModels,getContext()));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    }, (VolleyError volleyError) -> {
                Toast.makeText(getContext(), volleyError.toString(), Toast.LENGTH_SHORT).show();

            }

            ) {

            };
            @SuppressLint("UseRequireInsteadOfGet")
            RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
            requestQueue.add(request);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();

        }
    }



    static class CategoriesListApdaptor extends RecyclerView.Adapter<CategoriesListApdaptor.MyViewholder> {

        RestaurantMenuListItemModel[] restaurantMenuListItemModels;
        Context context;
        public CategoriesListApdaptor(RestaurantMenuListItemModel[] restaurantMenuListItemModels,
                                      Context context) {
            this.restaurantMenuListItemModels=restaurantMenuListItemModels;
            this.context=context;
        }

        @NonNull
        @Override
        public CategoriesListApdaptor.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_menu_item_list, parent, false);
            return new CategoriesListApdaptor.MyViewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CategoriesListApdaptor.MyViewholder holder, int position) {
            holder.itemManuName.setText(restaurantMenuListItemModels[position].getItemName());
            holder.menuItemOrderView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, AddToCart.class));
                }
            });

        }

        @Override
        public int getItemCount() {
            return restaurantMenuListItemModels.length;
        }

        public static class MyViewholder extends RecyclerView.ViewHolder {
            TextView itemManuName;
            RelativeLayout menuItemOrderView;

            public MyViewholder(@NonNull View itemView) {
                super(itemView);
                itemManuName = itemView.findViewById(R.id.itemManuName);
                menuItemOrderView = itemView.findViewById(R.id.menuItemOrderView);
            }
        }
    }

}