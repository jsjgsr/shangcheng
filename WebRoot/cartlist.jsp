<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="cart_createDingDan.do">
	<table style='border: 2px'>
		<tr>
		<td>选择</td>
		<td>商品名：</td>
		<td>商品图片：</td>
		<td>商品单价：</td>
		<td>商品操作：</td>
		</tr>
		<s:iterator var="p" value="cartlist"> <!-- 在session里面的遍历 -->
		
		<tr>
		<td><input name="selectid" type="checkbox" id="selectid" value="${p.cid}"></td>
		<td>${p.pname}</a></td>
		<td>${p.num}</a></td>
		<td>${p.cprice}</td>
		<td>删除</a>&nbsp;&nbsp;&nbsp; </td>
		</tr>
		</s:iterator>
	</table>
	<input type="submit" value = "提交订单"> 
	</form>
	<s:if test="#session.state == 2"><a href="pro_add.jsp">添加产品</a></s:if>  
  </body>
  
</html>
