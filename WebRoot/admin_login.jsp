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
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
     管理员登录<br>
    <form action="user_adminLogin.do"  method="post"  name="form1"  target="_self" name="RegForm"  onSubmit="return InputCheck(this)" >
                <tr>
                  <td align="left">管理员名
                    <input name="uname" type="text" class="login_1"  />
                  </td>
                </tr>
                <tr>
                  <td align="left">密码 ： 
                    <input name="upwd" type="password" class="login_1" /></td>
                </tr>
     </form>
  </body>
</html>
