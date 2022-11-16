package com.blue.pojo.vo;

import com.blue.pojo.Cart;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author shkstart

 */
public class GoodsVo {
    private Integer id;
    private String name;
    private String store;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    private String imgPath="img/default.jpg";
    private List<Cart> cartList;//这个属性 表示 这个商品对象 有在哪些购物车对象中

    public GoodsVo() {
    }

    public GoodsVo(Integer id, String name, String store, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.store = store;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.imgPath = imgPath;
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

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
