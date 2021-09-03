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
	<p>포워드 액션 태그</p>
	<hr>
	
<%
	String userid = request.getParameter("userid");
	if(userid == null || userid.length() == 0) {
		String msg = "아이디가 비어 있습니다.";
%>
	<jsp:forward page="loginform3.jsp">
		<jsp:param value="<%=msg%>" name="msg"/>
	</jsp:forward>		
<%		
	}
%>	

	<h2>로그인 성공</h2>
	<h3><%=userid%> 님 환영합니다.</h3>
</body>
</html>