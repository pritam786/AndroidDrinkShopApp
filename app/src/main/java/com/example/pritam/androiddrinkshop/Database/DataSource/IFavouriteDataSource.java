package com.example.pritam.androiddrinkshop.Database.DataSource;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Query;

import com.example.pritam.androiddrinkshop.Database.ModelDB.Favourite;

import java.util.List;

import io.reactivex.Flowable;

public interface IFavouriteDataSource {


    Flowable<List<Favourite>> getFavItems();


    int isFavourite(int itemId);

    void  insertFav(Favourite...favourites);


    void delete(Favourite favourite);
}
