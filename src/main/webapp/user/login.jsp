<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <%@include file="/common/head.jsp"%>
<%--    <script type="text/javascript" src="../script/jquery-1.7.2.js"></script>--%>
    <style type="text/css">
        .itxt {
            width: 160px;
            height: 25px;
        }
    </style>
</head>
<body>

<div class="login_header" style="color: black; ">
    <h1 style="text-align: center">欢迎来到购物小商城</h1>
</div>

<div style="text-align: center">

    <span class="erroMsg" style="color: crimson">
        ${empty requestScope.msg ?"请进行登录":requestScope.msg}
    </span>
    <div>
        <form action="userServlet" method="post">
            <input hidden="hidden" name="action" value="login">
            <br>
            <label style="font-size: 20px">用户名称：</label>
            <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" name="username"
             value="${sessionScope.user.username}">
            <br><br>
            <label style="font-size: 20px">用户密码：</label>
            <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" name="password"
            >
            <br><br>
            <div>
                <input type="radio" name="isCus" value="0">商家
                <input type="radio" name="isCus" value="1" checked="checked">用户
            </div>
            <br>
            <div>
                <input type="submit" id="btn_login" value="登录" style="width: 100px;height: 30px;">
            </div>
        </form>
    </div><br>
    <a href="user/regist.jsp" target="_self">
        <button style="width: 100px;height: 30px;">注册</button>
    </a>

</div>

</div>
</body>
</html>