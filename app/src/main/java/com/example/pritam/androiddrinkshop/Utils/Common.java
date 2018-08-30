package com.example.pritam.androiddrinkshop.Utils;

import com.example.pritam.androiddrinkshop.Model.Category;
import com.example.pritam.androiddrinkshop.Model.Drink;
import com.example.pritam.androiddrinkshop.Model.User;
import com.example.pritam.androiddrinkshop.Retrofit.IDrinkShopAPI;
import com.example.pritam.androiddrinkshop.Retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class Common {
    private static final String BASE_URL = "http://192.168.0.101/drinkshop/";

    public static final String TOPPING_MENU_ID = "7";

    public static User currentUser = null;
    public static Category currentCategory = null;

    public static List<Drink> toppingList = new ArrayList<>();

    public static double toppingprice = 0.0;
    public static List<String> toppingAdded = new ArrayList<>();

    //Hold Field
    public static int sizeOfCup = -1; // -1 : no choose (error) , 0 : M, 1 : L
    public static int sugar = -1;
    public static int ice = -1;

    public static IDrinkShopAPI getAPI() {

        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}
