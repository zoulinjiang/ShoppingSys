package com.blue.service;

import com.blue.pojo.Cart;

/**
 * @author shkstart
 * @create 2022-11-13 11:13
 */
public interface CartService {
    public void createCart(Cart cart);

    public Cart queryCart(Integer userId);
}
