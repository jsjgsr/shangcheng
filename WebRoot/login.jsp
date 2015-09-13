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
    This is my JSP page. <br>
    <form action="user_userLogin.do"  method="post"  name="form1"  target="_self" name="RegForm"  onSubmit="return InputCheck(this)" >
                <tr>
                  <td align="left">用户名
                    <input name="uname" type="text" class="login_1"  />
                  </td>
                </tr>
                <tr>
                  <td align="left">密码 ： 
                    <input name="upwd" type="password" class="login_1" /></td>
                </tr>
                <input type="submit" value="登录" /><a href="user_save.jsp">新用户注册</a>
     </form>
  </body>
</html>
