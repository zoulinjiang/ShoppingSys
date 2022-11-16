package com.blue.test;

import com.blue.dao.GoodsDao;
import com.blue.dao.impl.GoodsDaoImpl;
import com.blue.pojo.Goods;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-06 15:22
 */
public class GoodsDaoTest {
    GoodsDao goodsDao=new GoodsDaoImpl();

    @Test
    public void addGoods(){
        Goods goods=new Goods(null,"珍珠耳环","雯雯制作",new BigDecimal(55),300,200,null);
        System.out.println(goodsDao.addGoods(goods));
    }
    @Test
    public void updateGoods(){
        Goods goods=new Goods(12,"珍珠耳环","雯雯制作",new BigDecimal(55),300,200,null);
        System.out.println(goodsDao.updateGoods(goods));
    }
    @Test
    public void deleteGoods() {
        System.out.println(goodsDao.deleteGoods(14));
    }
    @Test
    public void queryByGoodsId() {
        System.out.println(goodsDao.queryByGoodsId(12));
    }
        @Test
    public void queryGoods(){
        for(Goods goods:goodsDao.queryGoods()){
            System.out.println(goods);
        }
    }



}
