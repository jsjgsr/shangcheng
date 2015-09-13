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
       <s:if test="#session.user != null"><td align="center">您好，<s:if test="#session.state == 1"><strong><s:property value="#session.user.uname"/></strong></s:if><s:if test="#session.state == 2"><strong><s:property value="#session.admin.uname"/></strong></s:if>（<a href="user_changeinfo.do?userid=<s:property value="#session.user.uid"/>" target="I1">个人信息修改</a> &nbsp;  <a href="user_out.do">退出</a>）<a href="cart_cartlist.do">显示购物车产品列表</a>
       <a href="dd_ddlist.do">查看订单</a>
        </td></s:if>
	<table style='border: 2px'>
		<tr><td>商品名：</td><td>商品图片：</td><td>商品单价：</td><td>商品操作：</td></tr>
		<s:iterator var="p" value="productlist"> <!-- 在session里面的遍历 -->
		<tr><td><a href="pro_info?pid=${p.pid}">${p.pname}</a></td>
		<td><a href="pro_info?pid=${p.pid}">${p.url}</a></td>
		<td>${p.price}</td>
		
		
		<td><a href="pro_info?pid=${p.pid}">立即购买</a>&nbsp;&nbsp;&nbsp; <a href="pro_info?pid=${p.pid}">加入购物车</a></td>
		</tr>
		</s:iterator>
	</table>
	<s:if test="#session.state == 2"><a href="pro_add.jsp">添加产品</a></s:if>  
  </body>
  
</html>
