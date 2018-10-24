<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

 
  </head>
  
  <body>
    <h1>変更</h1>
    <form action="servletusers?do=edit" method="post">
    <input type="hidden" name="id" value="${edituser.id }">
    名前：<input name="name" value="${edituser.name }"><br>
    メール：<input name="email" value="${edituser.email }" ><br>
    <input type="submit" value="変更" > <input type="reset">
    </form>
  </body>
</html>
