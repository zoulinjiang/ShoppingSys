package com.blue.service.impl;

import com.blue.dao.CartItemDao;
import com.blue.dao.impl.CartItemDaoImpl;
import com.blue.pojo.CartItem;
import com.blue.service.CartItemService;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-15 16:59
 */
public class CartItemServiceImpl implements CartItemService {
    private CartItemDao cartItemDao=new CartItemDaoImpl();


    @Override
    public List<CartItem> queryForCartItem(Integer userId) {
        return cartItemDao.queryCartItem(userId);
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        //判断这个商品是否在购物车内，如果在，则数量+1，total_Price也对应相加
        //判断商品是否在购物车，要先获取购物车id
         cartItemDao.addCartItem(cartItem);

    }
}
