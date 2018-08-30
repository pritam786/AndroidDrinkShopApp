package com.example.pritam.androiddrinkshop.Utils;

import com.example.pritam.androiddrinkshop.Model.Category;
import com.example.pritam.androiddrinkshop.Model.User;
import com.example.pritam.androiddrinkshop.Retrofit.IDrinkShopAPI;
import com.example.pritam.androiddrinkshop.Retrofit.RetrofitClient;

public class Common {
    private static final String BASE_URL = "http://192.168.0.101/drinkshop/";

    public static User currentUser = null;
    public static Category currentCategory = null;

    public static IDrinkShopAPI getAPI() {

        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}
