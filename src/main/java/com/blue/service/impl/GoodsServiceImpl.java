package com.blue.service.impl;

import com.blue.dao.GoodsDao;
import com.blue.dao.impl.GoodsDaoImpl;
import com.blue.pojo.Goods;
import com.blue.service.GoodsService;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-06 15:27
 */
public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao=new GoodsDaoImpl();
    @Override
    public void addGoods(Goods goods) {
        goodsDao.addGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDao.updateGoods(goods);
    }

    @Override
    public Goods getGoods(Integer id) {
       return (Goods) goodsDao.queryByGoodsId(id);
    }

    @Override
    public void deleteGoods(Integer id) {
        goodsDao.deleteGoods(id);
    }

    @Override
    public List<Goods> queryGoods() {
        return goodsDao.queryGoods();
    }
}
