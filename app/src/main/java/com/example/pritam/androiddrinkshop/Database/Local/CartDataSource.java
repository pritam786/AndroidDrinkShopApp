package com.example.pritam.androiddrinkshop.Database.Local;

import com.example.pritam.androiddrinkshop.Database.DataSource.ICartDataSource;
import com.example.pritam.androiddrinkshop.Database.ModelDB.Cart;

import java.util.List;

import io.reactivex.Flowable;

public class CartDataSource implements ICartDataSource {

    private static CartDataSource instance;
    private CartDAO cartDAO;

    public CartDataSource(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    public static CartDataSource getInstance(CartDAO cartDAO) {
        if (instance == null)

            instance = new CartDataSource(cartDAO);
        return instance;

    }

    @Override
    public Flowable<List<Cart>> getCartItems() {
        return cartDAO.getCartItems();
    }

    @Override
    public Flowable<List<Cart>> getCartItembyId(int cartItemId) {
        return cartDAO.getCartItembyId(cartItemId);
    }

    @Override
    public int countCartItems() {
        return cartDAO.countCartItems();
    }

    @Override
    public float sumPrice() {
        return cartDAO.sumPrice();
    }

    @Override
    public void emptyCart() {

        cartDAO.emptyCart();
        ;

    }

    @Override
    public void insertToCart(Cart... carts) {

        cartDAO.insertToCart(carts);

    }

    @Override
    public void updateCart(Cart... carts) {

        cartDAO.updateCart(carts);

    }

    @Override
    public void deleteCartItem(Cart cart) {

        cartDAO.deleteCartItem(cart);

    }
}
