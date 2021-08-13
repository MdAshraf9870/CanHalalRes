package com.e.canhalalres.Models;

public class RestaurantMenuListItemModel {

        private Long id;
        private Long restaurantID;
        private String itemName;
        private Object itemImg;
        private Object quantity;
        private Long price;
        private Object description;
        private Boolean isActive;

    public RestaurantMenuListItemModel() {
    }

    public RestaurantMenuListItemModel(Long id, Long restaurantID, String itemName, Object itemImg, Object quantity, Long price, Object description, Boolean isActive) {
        this.id = id;
        this.restaurantID = restaurantID;
        this.itemName = itemName;
        this.itemImg = itemImg;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Long restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Object getItemImg() {
        return itemImg;
    }

    public void setItemImg(Object itemImg) {
        this.itemImg = itemImg;
    }

    public Object getQuantity() {
        return quantity;
    }

    public void setQuantity(Object quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
