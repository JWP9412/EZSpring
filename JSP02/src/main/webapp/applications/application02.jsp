<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String name = (String)session.getAttribute("name");
    	String tel = (String)application.getAttribute("tel");
    %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Session & application</title>
</head>
<body>
	<h1>애플리케이션 처리</h1>
	<p>세션은 동일한 브라우저에서만 속성값이 공유</p>
	<p>애플리케이션(application)은 브라우저에 관계없이 속성값이 공유(ServletContext)</p>
	<hr>
	<h3>이름(session) :<%=name %></h3>
	<h3>전화(application) :<%=tel %></h3>
</body>
</html>