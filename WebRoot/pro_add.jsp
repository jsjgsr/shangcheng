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
    登陆成功 <br>
       <td align="center">您好，<s:if test="#session.state == 1"><strong><s:property value="#session.user.uname"/></strong></s:if><s:if test="#session.state == 2"><strong><s:property value="#session.admin.uname"/></strong></s:if>（<a href="user_changeinfo.do?userid=<s:property value="#session.user.uid"/>" target="I1">个人信息修改</a> &nbsp;  <a href="user_out.do">退出</a>）</td>
	<form action="pro_add.do"  name="RegForm"  onSubmit="return InputCheck(this)" style="display:block; margin-bottom:20px" method="post" enctype="multipart/form-data" name="RegForm" onSubmit="return InputCheck(this)">
								<h4>产品名：</h4><input type="text" name="pname"><br><!-- name里的内容与创建对象的属性名要一样！！！ -->
								<h4>单价：</h4><input type="number" name="price"><br>
								<h4>图片：</h4><input type="text" name="url"><br>
								<h4>产品详情：</h4><input type="text" name="info"><br>
								<br><br>
								<input type="submit">
						</form> 
  </body>
  
</html>
