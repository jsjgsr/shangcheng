<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    用户登录 <br>
    <form action="user_save.do"  name="RegForm"  onSubmit="return InputCheck(this)" style="display:block; margin-bottom:20px" method="post" enctype="multipart/form-data" name="RegForm" onSubmit="return InputCheck(this)">
								<h4>用户名：</h4><input type="text" name="uname"><br><!-- name里的内容与创建对象的属性名要一样！！！ -->
								<h4>密码：</h4><input type="password" name="upwd"><br>
								<h4>验证密码：</h4><input type="text" name="repassword"><br>
								<h4>联系电话：</h4><input type="text" name="utel"><br>
								<h4>送货地址：</h4><input type="text" name="uaddress"><br>
								<br><br>
								<input type="submit">
						</form>
  </body>
</html>
