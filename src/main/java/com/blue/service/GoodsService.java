package com.blue.service;

import com.blue.pojo.Goods;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-06 15:30
 */
public interface GoodsService {
    /**
     * 增加商品
     * @param goods
     */
    public void addGoods(Goods goods);

    public void updateGoods(Goods goods);

    public Goods getGoods(Integer id);

    public void deleteGoods(Integer id);
    /**
     * 显示商品
     * @return
     */
    public List<Goods> queryGoods();
}
