package com.blue.service.impl;

import com.blue.dao.CartDao;
import com.blue.dao.impl.CartDaoImpl;
import com.blue.pojo.Cart;
import com.blue.service.CartService;

/**
 * @author shkstart
 * @create 2022-11-13 11:13
 */
public class CartServiceImpl implements CartService {
    private CartDao cartDao=new CartDaoImpl();
    @Override
    public void createCart(Cart cart) {
        cartDao.createCart(cart.getUserId());
    }

    @Override
    public Cart queryCart(Integer userId) {
        return cartDao.queryCart(userId);
    }
}
