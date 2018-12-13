<%@ page language="java" import="java.util.*" import="model.myClass" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<myClass> classes = (List<myClass>)request.getAttribute("classes");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>班级信息</title>
    
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
    	<div>
    		<table border="1">
    			<thead>
    				<tr>
    					<td>ID</td>
    					<td>编号</td>
    					<td>操作</td>
    				</tr>
    			</thead>
    			<tbody>
    				<%
    					for (myClass c : classes) {
    								String id = c.getClassCode();
    				%>
					<tr>
						<td><%=c.getClassCode() %></td>
						<td><%=c.getClassName()+"("+c.getNumber()+"人)"%></td>
						<td><a>编辑</a>&nbsp;&nbsp;<a href="./getStuByCondition.action?classId=<%=id %>">查看</a>&nbsp;&nbsp;<a>删除</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
    			<tfoot>
    				<tr>
    					<td align="center" colspan="3">共<%=classes.size()%>个班级</td>
    				</tr>
    			</tfoot>
    		</table>
    	</div>
    </center>
  </body>
</html>
