package com.e.canhalalres.Models;

public class CardsModel {
    private String bankName,Name,Date;

    public CardsModel(String bankName, String name, String date) {
        this.bankName = bankName;
        Name = name;
        Date = date;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
