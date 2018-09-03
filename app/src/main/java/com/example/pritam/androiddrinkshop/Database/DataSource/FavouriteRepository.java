package com.example.pritam.androiddrinkshop.Database.DataSource;

import com.example.pritam.androiddrinkshop.Database.ModelDB.Favourite;

import java.util.List;

import io.reactivex.Flowable;

public class FavouriteRepository implements IFavouriteDataSource {

    private IFavouriteDataSource favouriteDataSource;

    public FavouriteRepository(IFavouriteDataSource favouriteDataSource) {
        this.favouriteDataSource = favouriteDataSource;
    }

    private static FavouriteRepository instance;
    public static FavouriteRepository getInstance(IFavouriteDataSource favouriteDataSource)
    {
        if (instance == null)
            instance = new FavouriteRepository(favouriteDataSource);
        return instance;
    }

    @Override
    public Flowable<List<Favourite>> getFavItems() {
        return favouriteDataSource.getFavItems();
    }

    @Override
    public int isFavourite(int itemId) {
        return favouriteDataSource.isFavourite(itemId);
    }

    @Override
    public void insertFav(Favourite... favourites) {

        favouriteDataSource.insertFav(favourites);

    }

    @Override
    public void delete(Favourite favourite) {

        favouriteDataSource.delete(favourite);

    }
}
