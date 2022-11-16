package com.blue.pojo;

import java.math.BigDecimal;

/**
 * @author shkstart
 *     /*private Integer cartId;
 *     private Integer goodsId;
 *     private Integer count;
 *
 */
public class CartItem {

    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private Integer cartId;

    public CartItem() {
    }

    public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalPrice, Integer cartId) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.cartId = cartId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", cartId=" + cartId +
                '}';
    }
}
