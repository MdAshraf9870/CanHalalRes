package com.e.canhalalres.Activity.Dashboard;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.e.canhalalres.Activity.Login;
import com.e.canhalalres.Activity.RestaurantDetail.ManuItemListFragment;
import com.e.canhalalres.Models.MyCartListModel;
import com.e.canhalalres.Models.RestaurantMenuListItemModel;
import com.e.canhalalres.R;
import com.e.canhalalres.Url.Url;
import com.e.canhalalres.Utils.CustomProgressDialog;
import com.e.canhalalres.Utils.CustomVolley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.jar.JarException;

public class MyCartFragment extends Fragment {
    LinearLayout linear_checkout;
    private RecyclerView my_cart_rv;
    Dialog pd;
    TextView my_add_to_cart_total_price, final_total_price;
    List<MyCartListModel> myCartListModels = new ArrayList<MyCartListModel>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);
        my_cart_rv = view.findViewById(R.id.my_cart_rv);
        my_add_to_cart_total_price = view.findViewById(R.id.my_add_to_cart_total_price);
        final_total_price = view.findViewById(R.id.final_total_price);

        pd = CustomProgressDialog.getInstance().customProgressDialog(getContext());

        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");


        getLogin();
        return view;
    }


    private void getLogin() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("userId", "1");
        if (pd != null) {
            pd.show();
        }
        try {
            CustomVolley.getInstance().postVolley(requireContext(), Url.my_Cart_view_oerder, hashMap, "My Cart", new CustomVolley.IRequestCallbacks() {
                @Override
                public void onStringResponse(String response) {
                    if (response != null && !response.isEmpty()) {
                        if (pd != null && pd.isShowing()) {
                            pd.dismiss();
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                GsonBuilder gsonBuilder = new GsonBuilder();
                                Gson gson = gsonBuilder.create();
//                                JSONArray jsonArray =new JSONArray(jsonObject.getString("data"));
//                                for ()
//                                MyCartListModel myCartListModel=
//                                        new MyCartListModel(
//                                                jsonArray.getJSONObject()
//                                        );

                                MyCartListModel[] myCartListModels = gson.fromJson(jsonObject.getString("data"), MyCartListModel[].class);
                                my_cart_rv.setAdapter(new MyCartAdaptor(myCartListModels, getContext()));


                            } catch (JSONException e) {
                                Log.d("TagNew", e.getMessage().toString());
                            }
                        }
                    } else {
                        pd.dismiss();
                        Toast.makeText(getContext(), "response is empty", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    pd.dismiss();
                    Toast.makeText(getContext(), volleyError.toString(), Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            e.getMessage();
        }
    }

    @SuppressLint("SetTextI18n")
    private class MyCartAdaptor extends RecyclerView.Adapter<MyCartAdaptor.MyviewHolder> {

        int total = 0;
        int getPrice;
        MyCartListModel[] myCartListModels;

        public MyCartAdaptor(MyCartListModel[] myCartListModels, Context context) {
            this.myCartListModels = myCartListModels;
        }


        @NonNull
        @Override
        public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_add_to_cart_list, parent, false);
            return new MyviewHolder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

//            for (int i=0; i<=myCartListModels.length; i++){
//                int b=0;
//                int a=+myCartListModels[b].getPrice();
//                my_add_to_cart_total_price.setText("$"+a);
//                b++;
//            }

            //   holder.item_name.setText(myCartListModels[position].getMenuItemID() == 0 ? "no" : "" + myCartListModels[position].getMenuItemID());
            holder.add_to_cart_price.setText(myCartListModels[position].getPrice() == 0 ? "no" : "" + myCartListModels[position].getPrice());
            holder.Count_add_to_cart.setText(myCartListModels[position].getQuantity() == 0 ? "no" : "" + myCartListModels[position].getQuantity());

            getPrice = myCartListModels[position].getPrice();
            int getQuantity = myCartListModels[position].getQuantity();

            total = ((getPrice * getQuantity) + total);
            my_add_to_cart_total_price.setText("$" + (total));
            final_total_price.setText("$" + (total));
//                total=getPrice;
            holder.plus_add_to_cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPrice = myCartListModels[position].getPrice();
                    int d = Integer.parseInt(my_add_to_cart_total_price.getText().toString().replace("$", ""));
                    my_add_to_cart_total_price.setText("$" + (d + getPrice));
                    final_total_price.setText("$" + (d + getPrice));
                    getPrice = 0;

                }
            });
            holder.minus_add_to_cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPrice = myCartListModels[position].getPrice();
                    int d = Integer.parseInt(my_add_to_cart_total_price.getText().toString().replace("$", ""));
                    my_add_to_cart_total_price.setText("$" + (d - getPrice));
                    final_total_price.setText("$" + (d - getPrice));
                    getPrice = 0;
                }
            });
        }

        @Override
        public int getItemCount() {
            return myCartListModels.length;
        }

        public class MyviewHolder extends RecyclerView.ViewHolder {
            TextView item_name, add_to_cart_price, Count_add_to_cart;
            ImageView minus_add_to_cart, plus_add_to_cart;

            public MyviewHolder(@NonNull View itemView) {
                super(itemView);
                item_name = itemView.findViewById(R.id.item_name);
                add_to_cart_price = itemView.findViewById(R.id.add_to_cart_price);
                Count_add_to_cart = itemView.findViewById(R.id.Count_add_to_cart);
                minus_add_to_cart = itemView.findViewById(R.id.minus_add_to_cart);
                plus_add_to_cart = itemView.findViewById(R.id.plus_add_to_cart);
            }
        }
    }
}