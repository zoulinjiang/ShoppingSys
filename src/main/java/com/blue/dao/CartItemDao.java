package com.blue.dao;

import com.blue.pojo.Cart;
import com.blue.pojo.CartItem;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-13 14:22
 */
public interface CartItemDao {
    public int addCartItem(CartItem cartItem);
    public List<CartItem> queryCartItem(Integer userId);
}
