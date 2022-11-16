package com.blue.web;


import com.blue.pojo.User;
import com.blue.service.UserService;
import com.blue.service.impl.UserServiceImpl;
import com.blue.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2022-10-28 19:22
 */
public class UserServlet extends BaseServlet {
    private UserService userService =new UserServiceImpl();

    /**
     * 登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Integer isCus=WebUtils.parseInt(req.getParameter("isCus"),0);
        //调用方法
        User loginuser= userService.login(username,password,isCus);
        if(loginuser==null){
            //为空，表明password或者username错误
            //回显错误信息，告诉用户
            System.out.println("错误");
            req.setAttribute("msg","用户身份，用户名或密码错误");

            //返回登录页面
            req.getRequestDispatcher("/user/login.jsp").forward(req,resp);

        }else{//在登录成功之后，要先确定用户的身份，跳转的界面，是否含有【商品管理】【订单管理】，用户只有【购物车】

            req.getSession().setAttribute("user",loginuser);
            //不为空，则登录成功
            req.getRequestDispatcher("/user/login_success.jsp").forward(req,resp);
        }

    }

    //注册
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取请求参数
        String username=req.getParameter("username");
       String password=req.getParameter("password");
       String email=req.getParameter("email");
       String code=req.getParameter("code");
       Integer isCus= WebUtils.parseInt(req.getParameter("isCus"),1);


        //看验证码是否输入正确，这个验证码写死的吗，哈哈
       if("abcd".equals(code)){
           if(userService.existUsername(username)){
               System.out.println("该用户名【"+username+"】已存在！");
               req.setAttribute("msg","该用户名已存在");

               //回显信息保存在request域中
               req.setAttribute("username",username);
               req.setAttribute("email",email);
               req.getRequestDispatcher("/user/regist.jsp").forward(req,resp);
           }else{
               //封装对象
               //调用函数
               userService.regist(new User(null,username,password,email,isCus));

               req.getRequestDispatcher("/user/regist_success.jsp").forward(req,resp);
           }
       }else{
           System.out.println("验证码输入错误！");
           req.setAttribute("msg","验证码错误");
           //回显信息保存在request域中
           req.setAttribute("username",username);
           req.setAttribute("email",email);
           req.getRequestDispatcher("/user/regist.jsp").forward(req,resp);
       }

    }
}
