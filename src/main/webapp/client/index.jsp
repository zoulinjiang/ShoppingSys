<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script>
        $(function () {
            $(".addToCart").click(function () {
                var id=$(this).attr("goodId");
                location.href="http://localhost:8080/ShoppingSys/carServlet?action=addCart&id="+id+"&userId="+${sessionScope.user.id};
            });
        });
    </script>
</head>
<body>
${sessionScope.user}
<div id="header">
    <span  style="text-align: center">购物</span>
    <%--判断用户是否登陆，如果未登录，显示登录     <c:if test="${empty sessionScope.user}"></c:if>--%>

    <a href="user/login.jsp">登录</a> |
    <a href="user/regist.jsp">注册</a> &nbsp;&nbsp;

    <%--        判断用户是否是商家，如果是商家显示店铺管理--%>
    <%--        <c:if test="${empty sessionScope.user.isCus==1}"></c:if>--%>
    <a href="shopmanager/goodsServlet?action=listGoods">后台管理</a>

    <a href="">购物车</a>
</div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="" method="get">
                价格：<input id="min" type="text" name="min" value=""> 元 -
                <input id="max" type="text" name="max" value=""> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <div style="text-align: center">
            <span>您的购物车中有3件商品</span>
            <div>
                您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
            </div>
        </div>
        <c:forEach items="${requestScope.goods}" var="good">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="img/default.jpg"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">商品:</span>
                        <span class="sp2">${good.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">店铺:</span>
                        <span class="sp2">${good.store}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${good.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${good.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${good.stock}</span>
                    </div>
                    <div class="book_add">
                        <button goodId="${good.id}" class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>


    </div>


</div>

</body>
</html>