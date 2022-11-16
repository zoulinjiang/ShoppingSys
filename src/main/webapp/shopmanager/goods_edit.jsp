<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css" >
	<%@include file="/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<span class="wel_word">商品管理</span>
			<div>
				<a href="order_manager.html">订单管理</a>
				<a href="index.jsp">返回商城</a>
			</div>
		</div>
		
		<div id="main">
			<form action="shopmanager/goodsServlet">
				<input type="hidden" name="action" value="${empty param.id?"addGoods":"updateGoods"}">
				<input type="hidden" name="id" value="${requestScope.good.id}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>商家</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.good.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.good.price}"/></td>
						<td><input name="store" type="text" value="${sessionScope.user.username}"/></td>
						<td><input name="sales" type="text" value="${requestScope.good.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.good.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

</body>
</html>