package com.e.canhalalres.Models;

import android.content.Intent;

//public class modelGetCategories {
//    int id;
//    String name,type,catImg,imgUrl,status,createdDate,updatedDate,createdBy,isDeleted,catImgName;
//
//    public modelGetCategories() {
//    }
//
//    public modelGetCategories(int id, String name, String type, String catImg, String imgUrl, String status, String createdDate, String updatedDate, String createdBy, String isDeleted, String catImgName) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//        this.catImg = catImg;
//        this.imgUrl = imgUrl;
//        this.status = status;
//        this.createdDate = createdDate;
//        this.updatedDate = updatedDate;
//        this.createdBy = createdBy;
//        this.isDeleted = isDeleted;
//        this.catImgName = catImgName;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getCatImg() {
//        return catImg;
//    }
//
//    public void setCatImg(String catImg) {
//        this.catImg = catImg;
//    }
//
//    public String getImgUrl() {
//        return imgUrl;
//    }
//
//    public void setImgUrl(String imgUrl) {
//        this.imgUrl = imgUrl;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(String createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public String getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(String updatedDate) {
//        this.updatedDate = updatedDate;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getIsDeleted() {
//        return isDeleted;
//    }
//
//    public void setIsDeleted(String isDeleted) {
//        this.isDeleted = isDeleted;
//    }
//
//    public String getCatImgName() {
//        return catImgName;
//    }
//
//    public void setCatImgName(String catImgName) {
//        this.catImgName = catImgName;
//    }
//}



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class modelGetCategories {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("catImg")
    @Expose
    private Object catImg;
    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("createdDate")
    @Expose
    private Object createdDate;
    @SerializedName("updatedDate")
    @Expose
    private Object updatedDate;
    @SerializedName("createdBy")
    @Expose
    private Object createdBy;
    @SerializedName("isDeleted")
    @Expose
    private Object isDeleted;
    @SerializedName("catImgName")
    @Expose
    private String catImgName;

    public modelGetCategories(Object id, String name, String type, Object catImg, String imgUrl, String status, Object createdDate, Object updatedDate, Object createdBy, Object isDeleted, String catImgName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.catImg = catImg;
        this.imgUrl = imgUrl;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdBy = createdBy;
        this.isDeleted = isDeleted;
        this.catImgName = catImgName;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
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

    public Object getCatImg() {
        return catImg;
    }

    public void setCatImg(Object catImg) {
        this.catImg = catImg;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getCatImgName() {
        return catImgName;
    }

    public void setCatImgName(String catImgName) {
        this.catImgName = catImgName;
    }

}