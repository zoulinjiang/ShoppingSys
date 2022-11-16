package com.blue.test;

import com.blue.dao.CartDao;
import com.blue.dao.impl.CartDaoImpl;
import com.blue.pojo.Cart;
import org.junit.jupiter.api.Test;

/**
 * @author shkstart
 * @create 2022-11-13 11:13
 */
public class CartDaoTest {
    private CartDao cartDao = new CartDaoImpl();

    @Test
    public void createCart() {
        System.out.println(cartDao.createCart(3));
    }

    @Test
    public void queryCart() {
        System.out.println(cartDao.queryCart(1));
    }
}
