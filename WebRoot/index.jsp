<%@ page language="java" import="java.util.*" import="model.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
List<Student> students = (List<Student>) request.getAttribute("students");
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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/student.css">
	<script type="text/javascript" src="./js/student.js" charset="utf-8"></script>
  </head>
  
  <body>
    <center>
    	<div>
    		<form action="getStuByCondition.action" method="post" name="searchForm">
    			属性&nbsp;&nbsp;
    			<select name="type" onChange="getCondition()">
    				<option value=""></option>
    				<option value="name">姓名</option>
    				<option value="age">年龄</option>
    			</select>
    			<select name="condition">
    				<option value=""></option>
    			</select>
    			<input type="text" name="value" />
    			<input value="提交" type="submit"/>
    		</form>
    		
    			<a href="javascript:window.location='fileUpload.jsp'">文件上传</a>
    			<a href="javascript:void(0)" onclick="setFileName()" >文件下载</a>
    		    		
    	</div>
    	<div>
    		<table border="1">
    			<thead>
    				<tr>
    					<td>学号</td>
    					<td>姓名</td>
    					<td class="text-right">年龄</td>
    				</tr>
    			</thead>
    			<tbody>
    				<%
						for (Student student : students) {
					%>
					<tr>
						<td><%=student.getStuID()%></td>
						<td><%=student.getStuName()%></td>
						<td class="text-right"><%=student.getStuAge()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
    			<tfoot>
    				<tr>
    					<td align="center" colspan="3">共<%=students.size() %>人</td>
    				</tr>
    			</tfoot>
    		</table>
    	</div>
    </center>
  </body>
</html>
