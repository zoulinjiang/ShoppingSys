package com.blue.web;


import com.blue.pojo.Goods;
import com.blue.service.GoodsService;
import com.blue.service.impl.GoodsServiceImpl;
import com.blue.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-06 15:47
 */
public class GoodsServlet extends BaseServlet {

    GoodsService goodsService=new GoodsServiceImpl();

    //在主页显示商品信息
    protected void listGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用函数goodsService.queryGoods()
        List<Goods> goods=goodsService.queryGoods();
        //放到request域
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("/shopmanager/goods_manager.jsp").forward(req, resp);


    }
    protected void addGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对于添加商品，获取用户的用户名，得到用户的店铺名字，获取参数
        String store= req.getParameter("store");
        String name=req.getParameter("name");
        BigDecimal price = BigDecimal.valueOf(WebUtils.parseInt(req.getParameter("price"), 0));
        Integer sales=WebUtils.parseInt(req.getParameter("sales"),0);
        Integer stock=WebUtils.parseInt(req.getParameter("stock"),0);
        //封装成商品对象
        Goods goods=new Goods(null,name,store,price,sales,stock,null);
        //调用goodsService.addGoods()函数
        goodsService.addGoods(goods);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/shopmanager/goodsServlet?action=listGoods");
    }

    protected void updateGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=WebUtils.parseInt(req.getParameter("id"),0);
        String name=req.getParameter("name");
        BigDecimal price = BigDecimal.valueOf(WebUtils.parseInt(req.getParameter("price"), 0));
        String store=req.getParameter("store");
        Integer sales=WebUtils.parseInt(req.getParameter("sales"),0);
        Integer stock=WebUtils.parseInt(req.getParameter("stock"),0);
        //封装成商品对象
        Goods goods=new Goods(id,name,store,price,sales,stock,null);
        goodsService.updateGoods(goods);
        resp.sendRedirect(req.getContextPath()+"/shopmanager/goodsServlet?action=listGoods");

    }

    protected void deleteGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取删除商品id
        Integer id=WebUtils.parseInt(req.getParameter("id"),0);
        //调用函数
        goodsService.deleteGoods(id);
        resp.sendRedirect(req.getContextPath()+"/shopmanager/goodsServlet?action=listGoods");
    }

        protected void getGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品的id参数
        Integer id=WebUtils.parseInt(req.getParameter("id"),0);
        //调用goodsService.queryBy
        Goods good=goodsService.getGoods(id);
        req.setAttribute("good",good);
        req.getRequestDispatcher("/shopmanager/goods_edit.jsp").forward(req,resp);
    }

}
