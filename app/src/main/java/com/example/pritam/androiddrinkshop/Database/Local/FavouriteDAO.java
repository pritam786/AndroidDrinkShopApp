package com.example.pritam.androiddrinkshop.Database.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.pritam.androiddrinkshop.Database.ModelDB.Favourite;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface FavouriteDAO {

    @Query("SELECT * FROM Favourite")
    Flowable<List<Favourite>> getFavItems();

    @Query("SELECT EXISTS (SELECT 1 FROM Favourite WHERE id=:itemId)")
    int isFavourite(int itemId);

    @Insert
    void  insertFav(Favourite...favourites);

    @Delete
    void delete(Favourite favourite);
}
