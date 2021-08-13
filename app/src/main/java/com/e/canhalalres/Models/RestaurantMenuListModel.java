package com.e.canhalalres.Models;


public class RestaurantMenuListModel {
    private Long id;
    private String name;
    private String type;
    private String catImg;
    private String status;
    private Object createdDate;
    private Object updatedDate;
    private Object createdBy;
    private Object isDeleted;

    public RestaurantMenuListModel() {
    }

    public RestaurantMenuListModel(Long id, String name, String type, String catImg, String status, Object createdDate, Object updatedDate, Object createdBy, Object isDeleted) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.catImg = catImg;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCatImg() {
        return catImg;
    }

    public void setCatImg(String catImg) {
        this.catImg = catImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Object createdDate) {
        this.createdDate = createdDate;
    }

    public Object getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Object updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Object isDeleted) {
        this.isDeleted = isDeleted;
    }
}
