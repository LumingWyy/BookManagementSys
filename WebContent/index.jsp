<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
 
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table {
	width: 600px;
	height: 300px;
}
td{ text-align:center;}
</style>
</head>
 
<body>
	<h1>ユーザー管理</h1>
	<table border="1px">
		<tr>
			<th>id</th>
			<th>名前</th>
			<th>メール</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${ulist }" var="data">
			<tr>
				<td>${data.id }</td>
				<td>${data.name }</td>
				<td>${data.email }</td>
				<td><a href="servletusers?do=editbefore&id=${data.id }">変更</a> <a
					href="servletusers?do=del&id=${data.id }" onclick="javascript:return confirm('削除しますか？');">削除</a></td>
			</tr>
		</c:forEach>
	</table>
	
<a href="add.jsp">新增</a>
</body>
</html>
