package com.e.canhalalres.Activity.Dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.e.canhalalres.R;

import java.util.ArrayList;

public class MyCartFragment extends Fragment {
    LinearLayout linear_checkout;
    private RecyclerView my_cart_rv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_cart, container, false);
        my_cart_rv=view.findViewById(R.id.my_cart_rv);


        ArrayList<String> arrayList =new ArrayList();
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");
        arrayList.add("Sandwiches");


        my_cart_rv.setAdapter(new MyCartAdaptor(arrayList));

        return view;
    }

    private class MyCartAdaptor extends RecyclerView.Adapter<MyCartAdaptor.MyviewHolder> {

        ArrayList<String> arrayList;
        public MyCartAdaptor(ArrayList<String> arrayList) {
        this.arrayList=arrayList;
        }


        @NonNull
        @Override
        public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.my_add_to_cart_list,parent,false);
          return new MyviewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
holder.item_name.setText(arrayList.get(position));
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class MyviewHolder extends RecyclerView.ViewHolder {
            TextView item_name;
            public MyviewHolder(@NonNull View itemView) {
                super(itemView);
                item_name=itemView.findViewById(R.id.item_name);
            }
        }
    }
}