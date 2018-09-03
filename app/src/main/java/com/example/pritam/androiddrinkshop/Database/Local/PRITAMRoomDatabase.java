package com.example.pritam.androiddrinkshop.Database.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pritam.androiddrinkshop.Database.ModelDB.Cart;
import com.example.pritam.androiddrinkshop.Database.ModelDB.Favourite;

@Database(entities = {Cart.class, Favourite.class}, version = 1)
public abstract class PRITAMRoomDatabase extends RoomDatabase {

    public abstract CartDAO cartDAO();
    public abstract FavouriteDAO favouriteDAO();

    private static PRITAMRoomDatabase instance;

    public static PRITAMRoomDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, PRITAMRoomDatabase.class, "PRITAM_DrinkShopDB")
                    .allowMainThreadQueries()
                    .build();

        return instance;
    }


}
