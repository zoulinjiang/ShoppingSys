package com.blue.service;

import com.blue.pojo.CartItem;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-15 16:53
 */
public interface CartItemService {
    public List<CartItem> queryForCartItem(Integer userId);

    public void addCartItem(CartItem cartItem);
}
