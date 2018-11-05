<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增学生</title>
    
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
  	<center>
  		<form action="addStudent.action" method="post" name="addForm">
  			班级<input type="text" name="student.ownClass.classId"/><br>
  			<s:fielderror fieldName="classId"/>
  			学号<input type="text" name="student.stuId"/><br>
  			姓名<input type="text" name="student.stuName"/><br>
  			年龄<input type="text" name="student.stuAge"/><br>
  			<input type="submit" value="提交"/>
  		</form>
  	</center>
  </body>
</html>
