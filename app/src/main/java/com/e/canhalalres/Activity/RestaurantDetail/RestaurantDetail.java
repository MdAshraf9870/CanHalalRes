package com.e.canhalalres.Activity.RestaurantDetail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.e.canhalalres.R;

import java.util.ArrayList;

public class RestaurantDetail extends AppCompatActivity {
    private RecyclerView categories_rvList;

    //    public RestaurantDetail(int i) {
    //    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            categories_rvList = findViewById(R.id.categories_rvList);
            getSupportFragmentManager().beginTransaction().replace(R.id.menuItemList_frame,new ManuItemListFragment()).commit();
            ArrayList<String> arrayList =new ArrayList();
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            arrayList.add("Sandwiches");
            categories_rvList.setLayoutManager(new LinearLayoutManager(
                    RestaurantDetail.this, LinearLayoutManager.HORIZONTAL, false));
            categories_rvList.setAdapter(new CategoriesListApdaptor(arrayList));

        }

    }

    static class CategoriesListApdaptor extends RecyclerView.Adapter<CategoriesListApdaptor.MyViewholder> {
        ArrayList<String> arrayList;
        int row_index;
        public CategoriesListApdaptor(ArrayList<String> arrayList) {
            this.arrayList=arrayList;
        }

        @NonNull
        @Override
        public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item_list, parent, false);
            return new MyViewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.listName.setText(arrayList.get(position));

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
            }
            else
            {
                holder.listName.setTextColor(Color.parseColor("#000000"));
                holder.manuItemBottomLine.setVisibility(View.GONE);
            }
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
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