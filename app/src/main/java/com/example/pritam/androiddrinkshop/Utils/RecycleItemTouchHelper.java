package com.example.pritam.androiddrinkshop.Utils;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.pritam.androiddrinkshop.Adapter.CartAdapter;
import com.example.pritam.androiddrinkshop.Adapter.FavouriteAdapter;

public class RecycleItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    RecyclerItemTouchHelperListener listener;


    public RecycleItemTouchHelper(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener listener) {
        super(dragDirs, swipeDirs);
        this.listener = listener;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        if (listener != null)
            listener.onSwipe(viewHolder, direction, viewHolder.getAdapterPosition());

    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        if (viewHolder instanceof  FavouriteAdapter.FavouriteViewHolder)
        {
            View foregroundView = ((FavouriteAdapter.FavouriteViewHolder)viewHolder).view_foreground;
            getDefaultUIUtil().clearView(foregroundView);
        }
        else if (viewHolder instanceof CartAdapter.CartViewHolder)
        {
            View foregroundView = ((CartAdapter.CartViewHolder)viewHolder).view_foreground;
            getDefaultUIUtil().clearView(foregroundView);
        }

    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {

        if (viewHolder != null) {
            if (viewHolder instanceof FavouriteAdapter.FavouriteViewHolder)
            {
                View foregroundView = ((FavouriteAdapter.FavouriteViewHolder)viewHolder).view_foreground;
                getDefaultUIUtil().onSelected(foregroundView);
            }
            else if (viewHolder instanceof CartAdapter.CartViewHolder)
            {
                View foregroundView = ((CartAdapter.CartViewHolder)viewHolder).view_foreground;
                getDefaultUIUtil().onSelected(foregroundView);
            }
        }
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

        if (viewHolder instanceof FavouriteAdapter.FavouriteViewHolder)
        {
            View foregroundView = ((FavouriteAdapter.FavouriteViewHolder) viewHolder).view_foreground;
            getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);

        }
        else if (viewHolder instanceof CartAdapter.CartViewHolder)
        {
            View foregroundView = ((CartAdapter.CartViewHolder) viewHolder).view_foreground;
            getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);

        }
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

        if (viewHolder instanceof FavouriteAdapter.FavouriteViewHolder)
        {
            View foregroundView = ((FavouriteAdapter.FavouriteViewHolder) viewHolder).view_foreground;
            getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
        }
        else  if (viewHolder instanceof CartAdapter.CartViewHolder)
        {
            View foregroundView = ((CartAdapter.CartViewHolder) viewHolder).view_foreground;
            getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);
        }
    }
}
