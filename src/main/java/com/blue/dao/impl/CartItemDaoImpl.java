package com.blue.dao.impl;

import com.blue.dao.CartItemDao;
import com.blue.pojo.CartItem;
import com.blue.pojo.vo.CartVo;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-13 14:22
 */
public class CartItemDaoImpl extends BaseDao implements CartItemDao {
    //加入购物车
    @Override
    public int addCartItem(CartItem cartItem) {
        String sql="INSERT INTO s_cart_item(`id`,`name`,`count`,`price`,`total_price`,`cart_id`) VALUES(NULL,?,?,?,?,?);";
        return update(sql,cartItem.getName(), cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),cartItem.getCartId());
    }

    @Override
    public List<CartItem> queryCartItem(Integer userId) {
        String sql="SELECT `id`,`name`,`count`,`price`,`total_price` totalPrice,`cart_id` cartId FROM s_cart_item where cart_Id=?";
        return getForList(CartVo.class,sql,userId);
    }

}
