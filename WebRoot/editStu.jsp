<%@ page language="java" import="java.util.*" import="model.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	/* List<Student> student = ((List<Student>)request.getAttribute("student")); */
	String className = request.getParameter("class");
	String stuId = request.getParameter("stuId");
	String stuName = request.getParameter("name");
	String stuAge = request.getParameter("stuAge");
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑信息</title>
    
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
  		<form action="editStu.action" method="post" name="editForm">
  			班级<input type="text" name="student.ownClass.classId" value='<%=className %>' disabled="disabled"/><br>
  			<s:fielderror fieldName="classId"/>
  			学号<input type="text" name="student.stuId" value='<%=stuId %>' disabled="disabled"/><br>
  			<s:fielderror fieldName="stuId"/>
  			姓名<input type="text" name="student.stuName" value='<%=stuName %>'/><br>
  			<s:fielderror fieldName="stuName"/>
  			年龄<input type="text" name="student.stuAge" value='<%=stuAge %>'/><br>
  			<s:fielderror fieldName="stuAge"/>
  			<input type="submit" value="提交修改"/>
  		</form>
  		<div>
    		<input type="button" value="返回上一页面" onclick="window.location='/first/getStuByCondition.action?classId=<%=className %>'"/>
    	</div>
  	</center>
  </body>
</html>
