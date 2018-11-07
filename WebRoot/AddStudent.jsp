<%@ page language="java" import="java.util.*" import="model.Student" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
// 	List<Student> student = ((List<Student>)request.getAttribute("student"));
//	System.out.println("student   "+student);
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
  			班级<input type="text" name="student.ownClass.classId" <%-- value='<%=student != null? student.get(0).getStuId() : "" %>' --%> /><br>
  			<s:fielderror fieldName="classId"/>
  			学号<input type="text" name="student.stuId"/><br>
  			<s:fielderror fieldName="stuId"/>
  			姓名<input type="text" name="student.stuName"/><br>
  			<s:fielderror fieldName="stuName"/>
  			年龄<input type="text" name="student.stuAge"/><br>
  			<s:fielderror fieldName="stuAge"/>
  			<input type="submit" value="提交"/>
  		</form>
  	</center>
  </body>
</html>
