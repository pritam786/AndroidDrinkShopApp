package com.example.pritam.androiddrinkshop.Database.DataSource;

import com.example.pritam.androiddrinkshop.Database.ModelDB.Cart;

import java.util.List;

import io.reactivex.Flowable;

public class CartRepository implements ICartDataSource {

    private static CartRepository instance;
    private ICartDataSource iCartDataSource;

    public CartRepository(ICartDataSource iCartDataSource) {
        this.iCartDataSource = iCartDataSource;
    }

    public static CartRepository getInstance(ICartDataSource iCartDataSource) {
        if (instance == null)
            instance = new CartRepository(iCartDataSource);
        return instance;
    }

    @Override
    public Flowable<List<Cart>> getCartItems() {
        return iCartDataSource.getCartItems();
    }

    @Override
    public Flowable<List<Cart>> getCartItembyId(int cartItemId) {
        return iCartDataSource.getCartItembyId(cartItemId);
    }

    @Override
    public int countCartItems() {
        return iCartDataSource.countCartItems();
    }

    @Override
    public void emptyCart() {

    }

    @Override
    public void insertToCart(Cart... carts) {

        iCartDataSource.insertToCart(carts);

    }

    @Override
    public void updateCart(Cart... carts) {

        iCartDataSource.updateCart(carts);

    }

    @Override
    public void deleteCartItem(Cart cart) {

        iCartDataSource.deleteCartItem(cart);

    }
}
