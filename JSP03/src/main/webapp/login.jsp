<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>로그인 처리</h1>
	<hr>
	
<%
	String userid = request.getParameter("userid");
	if(userid == null || userid.length() == 0) {
		RequestDispatcher dispatch = request.getRequestDispatcher("loginform.jsp");
		dispatch.forward(request, response);
	}
%>	

	<h2>로그인 성공</h2>
	<h3><%=userid%> 님 환영합니다.</h3>
</body>
</html>