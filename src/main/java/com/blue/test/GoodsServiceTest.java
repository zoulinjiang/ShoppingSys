package com.blue.test;

import com.blue.pojo.Goods;
import com.blue.service.GoodsService;
import com.blue.service.impl.GoodsServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2022-11-06 15:42
 */
public class GoodsServiceTest {
    GoodsService goodsService=new GoodsServiceImpl();
    @Test
    public void queryGoods(){
       for(Goods goods: goodsService.queryGoods()){
           System.out.println(goods);
       }
    }
    @Test
    public void updateGoods() {
        Goods goods=new Goods(13,"哭脸项链","雯雯制作",new BigDecimal(45),200,200,null);
        goodsService.updateGoods(goods);
    }
        @Test
    public void addGoods(){
        Goods goods=new Goods(null,"笑脸项链","雯雯制作",new BigDecimal(45),200,200,null);
        goodsService.addGoods(goods);
    }
    @Test
    public void deleteGoods() {
        goodsService.deleteGoods(15);
    }


    }
