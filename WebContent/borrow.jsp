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
    <h1>借りる</h1>
    <form action="servletbook?do=borrow" method="post">
    <input type="hidden" name="id" value="${editbook.id }">
    <input type="hidden" name="name" value="${editbook.name }"><br>
        <input type="hidden" name="author" value="${editbook.author }"><br>
    User ID：<input name="borrowerId" value="${editbook.borrowerId }" ><br>
    <input type="submit" value="借りる" > <input type="reset">
    </form>
  </body>
</html>
