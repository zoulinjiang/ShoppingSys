<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/common/head.jsp" %>
    <script>
        $(function () {
            $("a.deleteGoods").click(function (){
                confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗？")  ;
               // return false;
            });
        });
    </script>
</head>
<body>

<div id="header">
    <span class="wel_word">商品管理</span>

    <div>
        <p>欢迎${sessionScope.user.username}</p>
        <a href="">订单管理</a>
        <a href="index.jsp">返回商城</a>
    </div>

</div>

<div id="main">
    <table>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="shopmanager/goods_edit.jsp">添加商品</a></td>
        </tr>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.goods}" var="good">
            <tr>
                <td>${good.name}</td>
                <td>${good.price}</td>
                <td>${good.sales}</td>
                <td>${good.stock}</td>
                <td><a href="shopmanager/goodsServlet?action=getGoods&id=${good.id}">修改</a></td>
                <td><a class="deleteGoods" href="shopmanager/goodsServlet?action=deleteGoods&id=${good.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
</div>

</div>
</body>
</html>