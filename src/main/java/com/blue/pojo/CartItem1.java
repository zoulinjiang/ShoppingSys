package com.blue.pojo;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-13 21:45
 */
public class CartItem1 {
    private Cart cart;
    private List<Goods> goodsList;
    private Integer count;//理解下上面这两个属性，如果没有这个中间表实体类的话，封装外键 就需要两个Vo类
}
