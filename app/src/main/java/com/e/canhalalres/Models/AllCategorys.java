package com.e.canhalalres.Models;

import android.content.Intent;

public class AllCategorys {
    int id;
    String foodId,name,type,catImg,status,createdDate,updatedDate,createdBy,isDeleted,catImgName;

    public AllCategorys() {
    }

    public AllCategorys(int id, String foodId, String name, String type, String catImg, String status, String createdDate, String updatedDate, String createdBy, String isDeleted, String catImgName) {
        this.id = id;
        this.foodId = foodId;
        this.name = name;
        this.type = type;
        this.catImg = catImg;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.isDeleted = isDeleted;
        this.catImgName = catImgName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCatImgName() {
        return catImgName;
    }

    public void setCatImgName(String catImgName) {
        this.catImgName = catImgName;
    }
}
