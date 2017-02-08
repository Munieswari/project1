package com.BangleStore.service;

import com.BangleStore.model.Cart;


public interface CartService {

    Cart getCartById (int cartId);

    void update(Cart cart);
}
