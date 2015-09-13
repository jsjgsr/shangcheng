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
		<tr><td>订单号</td><td>总价</td><td>状态</td></tr>
		<s:iterator var="p" value="ddan"> <!-- 在session里面的遍历 -->
		<tr>
		<td><a href="pro_info?ddid=${p.ddid}">${p.ddid}</a></td>
		<td><a href="pro_info?ddid=${p.ddid}">${p.tprice}</a></td>
		<td>
		<s:if test="%{#p.state==0}">
		<a href="dd_zhifu?ddid=${p.ddid}">支付</a>
		</s:if>
		<s:if test="%{#p.state==1}">
		已支付支付
		</s:if>
		</td>
		&nbsp;&nbsp;&nbsp;
		</tr>
		</s:iterator>
	</table>
  </body>
  
</html>
