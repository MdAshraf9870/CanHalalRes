package com.e.canhalalres.Models;

import java.time.OffsetDateTime;

public class MyCartListModel {

    private int id;
    private int menuItemID;
    private int quantity;
    private int price;
    private int userID;
    private String createdDate;
    private String updatedDate;
    private Boolean createdBy;
    private Boolean isDeleted;

    public MyCartListModel() {
    }

    public MyCartListModel(int id, int menuItemID, int quantity, int price, int userID, String createdDate, String updatedDate, Boolean createdBy, Boolean isDeleted) {
        this.id = id;
        this.menuItemID = menuItemID;
        this.quantity = quantity;
        this.price = price;
        this.userID = userID;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Boolean createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
