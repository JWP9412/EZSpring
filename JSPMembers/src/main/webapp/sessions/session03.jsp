<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String name = (String)session.getAttribute("name");
    	String tel = (String)session.getAttribute("tel");
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Session</title>
</head>
<body>
	<h1>세션 처리</h1>
	<hr>
	<p>session02에서 세션을 통해 전달한 name,tel 속성값을 받음</p>
	<p>이름  : <%=name %></p>
	<p>전화  : <%=tel %></p>
	
	<a href='/JSP02/session01'> 첫 번째 페이지로 이동</a>
</body>
</html>