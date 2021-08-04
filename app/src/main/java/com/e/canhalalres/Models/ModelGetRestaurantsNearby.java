package com.e.canhalalres.Models;

public class ModelGetRestaurantsNearby {
    private int id;
    private String name;
    private String email;
    private String userName;
    private String countryCode;
    private String mobile;
    private String location;
    private String logoImg;
    private String bannerImg;
    private Double deliveryCharges;
    private Boolean isDelivery;
    private String type;
    private String status;
    private Boolean isDeleted;
    private Boolean isActive;
    private String logo;
    private String banner;

    public ModelGetRestaurantsNearby() {
    }

    public ModelGetRestaurantsNearby(int id, String name, String email, String userName, String countryCode, String mobile, String location, String logoImg, String bannerImg, Double deliveryCharges, Boolean isDelivery, String type, String status, Boolean isDeleted, Boolean isActive, String logo, String banner) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.countryCode = countryCode;
        this.mobile = mobile;
        this.location = location;
        this.logoImg = logoImg;
        this.bannerImg = bannerImg;
        this.deliveryCharges = deliveryCharges;
        this.isDelivery = isDelivery;
        this.type = type;
        this.status = status;
        this.isDeleted = isDeleted;
        this.isActive = isActive;
        this.logo = logo;
        this.banner = banner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public Double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public Boolean getDelivery() {
        return isDelivery;
    }

    public void setDelivery(Boolean delivery) {
        isDelivery = delivery;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}
