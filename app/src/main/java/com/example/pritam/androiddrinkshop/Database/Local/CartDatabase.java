package com.example.pritam.androiddrinkshop.Database.Local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pritam.androiddrinkshop.Database.ModelDB.Cart;

@Database(entities = {Cart.class}, version = 1)
public abstract class CartDatabase extends RoomDatabase {

    private static CartDatabase instance;

    public static CartDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context, CartDatabase.class, "PRITAM_DrinkShopDB")
                    .allowMainThreadQueries()
                    .build();

        return instance;
    }

    public abstract CartDAO cartDAO();
}
