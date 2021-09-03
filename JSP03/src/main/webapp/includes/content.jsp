<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String content = request.getParameter("content");
	String imagename = request.getParameter("imagename");
%>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Content JSP</title>
</head>
<body>
	<h1>content : <%=content%></h1>
	<hr>
	<img src="../images/<%=imagename%>" />
</body>
</html>