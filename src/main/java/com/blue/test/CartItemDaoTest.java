package com.blue.test;

import com.blue.dao.CartItemDao;
import com.blue.dao.GoodsDao;
import com.blue.dao.impl.GoodsDaoImpl;
import com.blue.pojo.CartItem;
import com.blue.pojo.Goods;
import com.blue.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author shkstart
 * @create 2022-11-13 15:15
 */
public class CartItemDaoTest {
    private CartItemDao cartItemDao=new com.blue.dao.impl.CartItemDaoImpl();
    @Test
    public void queryForCartItem1(){
        for(CartItem cartItems: cartItemDao.queryCartItem(1)){
            System.out.println(cartItems);
        }
    }
  /*  @Test
    public void queryForCartItem2() {
         for(CartItem cartItems: cartItemDao.queryCartItem()){
            System.out.println(cartItems);
        }
    }*/
        GoodsDao goodsDao=new GoodsDaoImpl();
    @Test
    public void queryGoods(){
        for(Goods goods:goodsDao.queryGoods()){
            System.out.println(goods);
        }
    }
}
