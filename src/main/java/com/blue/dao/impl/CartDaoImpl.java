package com.blue.dao.impl;

import com.blue.dao.CartDao;
import com.blue.pojo.Cart;
import com.blue.pojo.CartItem;

/**
 * @author shkstart
 * @create 2022-11-13 11:02
 */
public class CartDaoImpl extends BaseDao implements CartDao {

    @Override
    public int createCart(Integer id) {
        String sql = "INSERT INTO s_cart(`cart_id`,`user_id`,`total_count`,`total_money`) VALUES(NULL,?,0,0);";
        return update(sql, id);
    }

    @Override
    public Cart queryCart(Integer userId) {
        String sql="SELECT `cart_id` cartId,`user_id`userId,`total_count` totalCount,`total_money` totalMoney FROM `s_cart` WHERE `user_id`=?";
        return (Cart) queryForOne(Cart.class,sql,userId);
    }
}


