package com.blue.dao;

import com.blue.pojo.Cart;

/**
 * @author shkstart
 * @create 2022-11-13 11:02
 */
public interface CartDao {
    public int createCart(Integer id);
    public Cart queryCart(Integer userId);
}
