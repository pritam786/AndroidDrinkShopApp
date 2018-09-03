package com.example.pritam.androiddrinkshop;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.pritam.androiddrinkshop.Adapter.FavouriteAdapter;
import com.example.pritam.androiddrinkshop.Database.ModelDB.Favourite;
import com.example.pritam.androiddrinkshop.Utils.Common;
import com.example.pritam.androiddrinkshop.Utils.RecycleItemTouchHelper;
import com.example.pritam.androiddrinkshop.Utils.RecyclerItemTouchHelperListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FavouriteListActivity extends AppCompatActivity implements RecyclerItemTouchHelperListener {

    RecyclerView recycler_fav;

    RelativeLayout rootLayout;


    CompositeDisposable compositeDisposable;
    FavouriteAdapter favouriteAdapter;
    List<Favourite> localFavourites = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_list);

        compositeDisposable = new CompositeDisposable();

        rootLayout = (RelativeLayout)findViewById(R.id.rootLayout);

        recycler_fav = (RecyclerView)findViewById(R.id.recycler_fav);
        recycler_fav.setLayoutManager(new LinearLayoutManager(this));
        recycler_fav.setHasFixedSize(true);

        ItemTouchHelper.SimpleCallback simpleCallback = new RecycleItemTouchHelper(0,ItemTouchHelper.LEFT,this);

        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recycler_fav);

        loadFavouritesItem();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadFavouritesItem();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

    private void loadFavouritesItem() {

        compositeDisposable.add(Common.favouriteRepository.getFavItems()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Consumer<List<Favourite>>() {
            @Override
            public void accept(List<Favourite> favourites) throws Exception {

                displayFavouritesItem(favourites);

            }
        }));
    }

    private void displayFavouritesItem(List<Favourite> favourites) {

        localFavourites = favourites;
        FavouriteAdapter favouriteAdapter = new FavouriteAdapter(this,favourites);
        recycler_fav.setAdapter(favouriteAdapter);
    }

    @Override
    public void onSwipe(RecyclerView.ViewHolder viewHolder, int direction, int position) {

        if (viewHolder instanceof FavouriteAdapter.FavouriteViewHolder)
        {
            String name = localFavourites.get(viewHolder.getAdapterPosition()).name;

            final Favourite deletedItem = localFavourites.get(viewHolder.getAdapterPosition());
            final int deletedIndex = viewHolder.getAdapterPosition();

            //Delete item from adapter
            favouriteAdapter.removeItem(deletedIndex);
            //Delete item from Room database
            Common.favouriteRepository.delete(deletedItem);

            Snackbar snackbar = Snackbar.make(rootLayout,new StringBuilder(name).append("Removed from Favourites List").toString(),
                    Snackbar.LENGTH_LONG);

            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    favouriteAdapter.restoreItem(deletedItem,deletedIndex);
                    Common.favouriteRepository.insertFav(deletedItem);
                }
            });

            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();



        }
    }
}
