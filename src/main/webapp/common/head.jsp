<%--
  Created by IntelliJ IDEA.
  User: 罗文莉
  Date: 2022/11/8
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()
            +"://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";
    //pageContext.setAttribute("basePath",basePath);
%>
<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="css/style.css" >
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>