<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	session.setAttribute("name","Hong");
    	application.setAttribute("tel", "123");
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Session & application</title>
</head>
<body>
	<h1>애플리케이션 처리</h1>
	<hr>
	<p>세션으로 이름(name)과 애플리케이션으로 전화번호(tel)을 application02.jsp에서 공유</p>	
	<a href='application02.jsp'>애플리케이션(application02.jsp) 페이지로 이동</a>
</body>
</html>