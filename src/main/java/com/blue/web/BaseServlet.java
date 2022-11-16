package com.blue.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shkstart
 * @create 2022-10-28 19:22
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集的编码
        req.setCharacterEncoding("UTF-8");
        String action=req.getParameter("action");
        try {
            //action鉴别字符串，获取业务，方法反射对象
            Method method=this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务 方法
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
