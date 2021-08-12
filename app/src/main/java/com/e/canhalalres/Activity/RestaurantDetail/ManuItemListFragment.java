package com.e.canhalalres.Activity.RestaurantDetail;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.e.canhalalres.R;

import java.util.ArrayList;


public class ManuItemListFragment extends Fragment {
private RecyclerView menuItenLsit;

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

        menuItenLsit.setAdapter(new CategoriesListApdaptor(arrayList));
        return view;
    }

    static class CategoriesListApdaptor extends RecyclerView.Adapter<CategoriesListApdaptor.MyViewholder> {
        ArrayList<String> arrayList;
        public CategoriesListApdaptor(ArrayList<String> arrayList) {
            this.arrayList=arrayList;
        }

        @NonNull
        @Override
        public CategoriesListApdaptor.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_menu_item_list, parent, false);
            return new CategoriesListApdaptor.MyViewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CategoriesListApdaptor.MyViewholder holder, int position) {
            holder.itemManuName.setText(arrayList.get(position));

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public static class MyViewholder extends RecyclerView.ViewHolder {
            TextView itemManuName;

            public MyViewholder(@NonNull View itemView) {
                super(itemView);
                itemManuName = itemView.findViewById(R.id.itemManuName);
            }
        }
    }

}