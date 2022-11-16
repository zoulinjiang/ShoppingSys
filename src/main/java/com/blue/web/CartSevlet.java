package com.blue.web;

import com.blue.pojo.Cart;
import com.blue.service.CartItemService;
import com.blue.service.CartService;
import com.blue.service.impl.CartItemServiceImpl;
import com.blue.service.impl.CartServiceImpl;
import com.blue.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-11-15 17:19
 */
public class CartSevlet extends BaseServlet {
    private CartService cartService=new CartServiceImpl();
    private CartItemService cartItemService=new CartItemServiceImpl();

    protected void listCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户购物车id
        //调用函数，保存到request域对象
        //请求转发
    }

    protected void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id，用户购物车id 参数
        Integer id= WebUtils.parseInt(req.getParameter("id"),0);
        Integer userId=WebUtils.parseInt(req.getParameter("userId"),0);
        //找到用户购物车，查询商品信息
        Cart cart = cartService.queryCart(userId);

        //将商品转换为CartItem
        //添加到购物车
        //重定向
    }
}
