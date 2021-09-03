<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String name = (String)request.getAttribute("name");
    	String tel = (String)request.getAttribute("tel");
    %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Request Attribute</title>
</head>
<body>
	<h1>요청 속성 처리</h1>
	<hr>
	<h3>request02] 이름(session)  :<%=name %></h3>
	<h3>전화(application) :<%=tel %></h3>
</body>
</html>