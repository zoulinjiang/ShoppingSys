package com.blue.pojo.vo;

import com.blue.pojo.Goods;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-13 10:36
 */
public class CartVo {// Vo对象 就比实体类对象 多了封装外键数据的功能
    private Integer cartId;
    private Integer userId;
    private Integer totalCount=0;
    private Integer totalMoney=0;
    private List<Goods> goodsList;//这个属性 表示：该购物车对象 中有哪些商品对象

    public CartVo() {
    }

    public CartVo(Integer cartId, Integer userId, Integer totalCount, Integer totalMoney) {
        this.cartId = cartId;
        this.userId = userId;
        this.totalCount = totalCount;
        this.totalMoney = totalMoney;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", totalCount=" + totalCount +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
