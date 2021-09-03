<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    String hello = "Hello, JSP";
    public String getHello(){
    	return hello;
    }
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP Scripting Element</title>
</head>
<body>
	<h1>환영합니다.</h1>
	<h2><%= hello %></h2>
</body>
</html>