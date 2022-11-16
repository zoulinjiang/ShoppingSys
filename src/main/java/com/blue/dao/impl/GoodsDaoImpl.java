package com.blue.dao.impl;

import com.blue.dao.GoodsDao;
import com.blue.pojo.Goods;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-06 15:13
 */
public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public int addGoods(Goods goods) {
        String sql="insert into s_goods(`id`,`name`,`store`,`price`,`sales` , `stock` , `img_path`)values(?,?,?,?,?,?,?);";

        return update(sql,goods.getId(),goods.getName(),goods.getStore(),goods.getPrice(),goods.getSales(),goods.getStock(),goods.getImgPath());
    }

    @Override
    public int deleteGoods(Integer id) {
        String sql="delete from s_goods where id=?";
        return update(sql,id);
    }

    @Override
    public int updateGoods(Goods goods) {
        String sql="UPDATE s_goods SET `name`=?,`price`=?,`sales`=?,`stock`= ?,`img_path`=? WHERE id=?";
        return update(sql,goods.getName(),goods.getPrice(),goods.getSales(),goods.getStock(),goods.getImgPath(),goods.getId());
    }

    @Override
    public Goods queryByGoodsId(Integer id) {
        String sql="SELECT `id`,`name` , `store` , `price` , `sales` , `stock` , `img_path`FROM s_goods where `id`=?";
        return (Goods) queryForOne(Goods.class,sql,id);
    }


    @Override
    public List<Goods> queryGoods() {
        String sql="SELECT `id`,`name`,`store`,`price`,`sales`,`stock`, `img_path`FROM s_goods";
        return queryForList(Goods.class,sql);
    }
}
