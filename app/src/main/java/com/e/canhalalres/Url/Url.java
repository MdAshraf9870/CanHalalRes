package com.e.canhalalres.Url;

public class Url {
    private static final String Base = "http://ccepmt.com/api/";//live url

    public static final String login = Base + "account/login";
    public static final String Registration = Base + "User/register";
    public static final String Category_GetAll = Base + "Category/GetAll";
    public static final String Restaurant_GetAll = Base + "Restaurant/GetAll";
    public static final String Get_All_CatBy_RestId = Base + "Category/GetAllCatByRestId?id=";
    public static final String Category_Get_Cat_By_Rest = Base + "Category/GetCatByRestId?id=";
    public static final String Add_Cart = Base + "menu/AddToCart";
    public static final String my_Cart_view_oerder = Base + "Menu/ViewCart";
}
