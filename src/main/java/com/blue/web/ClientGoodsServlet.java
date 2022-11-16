package com.blue.web;

import com.blue.pojo.Goods;
import com.blue.service.GoodsService;
import com.blue.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-11-15 19:53
 */
public class ClientGoodsServlet extends BaseServlet{
    private GoodsService goodsService=new GoodsServiceImpl();

    protected void clientList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用函数goodsService.queryGoods()
        List<Goods> goods=goodsService.queryGoods();
        //放到request域
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("/client/index.jsp").forward(req, resp);

    }
}
