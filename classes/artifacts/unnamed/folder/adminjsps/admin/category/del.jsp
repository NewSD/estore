<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>删除分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {background: rgb(254,238,189);}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>
    <h1>删除分类</h1>
    <form action="${ pageContext.request.contextPath }/adminCategoryServlet" method="post">
    	<input type="hidden" name="method" value="delete" />
    	<input type="hidden" name="cid" value="${ category.cid }" />
    	分类名称：<input type="text" name="cname" value="${ category.cname }" disabled="disabled"/>
    	<input type="submit" value="删除分类"/>
    </form>
    <div class="icon">
    <a href="<c:url value='/adminjsps/admin/book/desc.jsp'/>"><img src="<c:url value='/book_img/8758723-1_l.jpg'/>" border="0"/></a>
      <br/>
   	<a href="<c:url value='/adminjsps/admin/book/desc.jsp'/>">Java就业培训教程</a>
  </div>
   <div class="icon">
    <a href="<c:url value='/adminjsps/admin/book/desc.jsp'/>"><img src="<c:url value='/book_img/8991366-1_l.jpg'/>" border="0"/></a>
      <br/>
   	<a href="<c:url value='/adminjsps/admin/book/desc.jsp'/>">精通Hibernate</a>
  </div>
    
     	<c:forEach items="${ list }" var="book">
	    	<div class="icon">
			    <a href="${pageContext.request.contextPath }/bookServlet?method=findByBid&bid=${book.bid}"><img src="${pageContext.request.contextPath }/${book.image}" border="0" width="130" height="140"/></a>
			      <br/>
			   	<a href="${pageContext.request.contextPath }/bookServlet?method=findByBid&bid=${book.bid}">${ book.bname }</a>
	  		</div>
	    </c:forEach>
  </body>
</html>
