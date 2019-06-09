<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background: rgb(78,78,78);color: white;">
<h1 style="text-align: center; ">ESTORE网络图书商城后台管理</h1>
	<c:if test="${ not empty existAdmin }">
		管理员：${ existAdmin.adminname } &nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="${ pageContext.request.contextPath }/adminServlet?method=logout" target="_parent">退出</a>&nbsp;&nbsp;|&nbsp;&nbsp;
	</c:if>
	<c:if test="${ empty existAdmin }">
		<a href="<c:url value='/adminjsps/login.jsp'/>" target="_parent">登录</a> |&nbsp; 
		<a href="<c:url value='/adminjsps/regist.jsp'/>" target="_parent">注册</a> |&nbsp; 
	</c:if>
		<a href="<c:url value='/jsps/main.jsp'/>" target="_parent">前台首页</a>
  </body>
</html>
