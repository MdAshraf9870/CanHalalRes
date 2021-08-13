package com.e.canhalalres.Models;

import androidx.recyclerview.widget.RecyclerView;

public class AddressModel {
    private String Name,Address,Number;



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public AddressModel(String name, String address, String number) {

        Name = name;
        Address = address;
        Number = number;
    }
}
