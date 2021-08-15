package com.e.canhalalres.Apdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.e.canhalalres.Models.AddressModel;
import com.e.canhalalres.R;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder>{
    private AddressModel[] addressModels;

    public AddressAdapter(AddressModel[] addressModels) {
        this.addressModels = addressModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.address_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final AddressModel myListData = addressModels[position];
        holder.txt_name.setText(addressModels[position].getName());
        holder.txt_address.setText(addressModels[position].getAddress());
        holder.txt_number.setText(addressModels[position].getNumber());
       /* holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return addressModels.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_name,txt_number,txt_address;
        public ViewHolder(View itemView) {
            super(itemView);
            this.txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            this.txt_number = (TextView) itemView.findViewById(R.id.txt_number);
            this.txt_address = (TextView) itemView.findViewById(R.id.txt_address);

        }
    }
}