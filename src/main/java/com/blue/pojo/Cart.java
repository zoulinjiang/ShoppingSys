package com.blue.pojo;

import java.math.BigDecimal;

/**
 * @author shkstart
 * @create 2022-11-13 10:36
 */
public class Cart {
    private Integer cartId;
    private Integer userId;
    private Integer totalCount;
    private BigDecimal totalMoney;

    public Cart() {
    }

    public Cart(Integer cartId, Integer userId, Integer totalCount, BigDecimal totalMoney) {
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

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
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
