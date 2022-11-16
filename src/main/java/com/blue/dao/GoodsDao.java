package com.blue.dao;

import com.blue.pojo.Goods;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-06 15:09
 */
public interface GoodsDao {
    /**
     * 商家增加商品
     * @param goods
     * @return
     */
    public  int addGoods(Goods goods);

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteGoods(Integer id);
    public List<Goods> queryGoods();
    public int updateGoods(Goods goods);

    public Goods queryByGoodsId(Integer  id);
}
