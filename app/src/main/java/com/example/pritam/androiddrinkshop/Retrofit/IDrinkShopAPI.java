package com.example.pritam.androiddrinkshop.Retrofit;

import com.example.pritam.androiddrinkshop.Model.Banner;
import com.example.pritam.androiddrinkshop.Model.Category;
import com.example.pritam.androiddrinkshop.Model.CheckUserResponse;
import com.example.pritam.androiddrinkshop.Model.Drink;
import com.example.pritam.androiddrinkshop.Model.User;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IDrinkShopAPI {

    @FormUrlEncoded
    @POST("checkuser.php")
    Call<CheckUserResponse> checkUserExists(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register.php")
    Call<User> registerNewUser(@Field("phone") String phone,
                               @Field("name") String name,
                               @Field("address") String address,
                               @Field("birthdate") String birthdate);

    @FormUrlEncoded
    @POST("getdrink.php")
    io.reactivex.Observable<List<Drink>> getDrink(@Field("menuid") String menuID);

    @FormUrlEncoded
    @POST("getuser.php")
    Call<User> getUserInformation(@Field("phone") String phone);

    @GET("getbanner.php")
    io.reactivex.Observable<List<Banner>>  getBanners();

    @GET("getmenu.php")
    io.reactivex.Observable<List<Category>>  getMenu();
}
