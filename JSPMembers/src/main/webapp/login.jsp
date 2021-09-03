<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login JSP</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<h3>아 이 디 : <%= userid %></h3>
	<h3>비밀번호 : <%= userpw %></h3>
</body>
</html>