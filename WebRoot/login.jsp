<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/login.css">
	<script type="text/javascript" src="./js/login.js" charset="utf-8"></script>
  </head>
  
  <body>
  	<center>
	  	<div class="login">
		    <form action="login.action" onsubmit="return isableToLogin()" name="loginForm">
		    	用户名：<input type="text" name="userName"><br>
		    	密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="userPwd" /><br>
		    	<input type="submit" value="登录"/>
		    </form>
	    </div>
    </center>
  </body>
  
</html>
