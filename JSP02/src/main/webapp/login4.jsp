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
	<form name="login" method="post" action="login.jsp">
		<table>
			<th>로그인</th>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userpw"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="로그인"></td>
				<td><input type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
	<hr>
</body>
</html>