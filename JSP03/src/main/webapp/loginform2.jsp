<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
%>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
</head>
<body>
	<h1>로그인 처리</h1>
	<p>포워드 액션 태그 예제</p>
	<p>아이디를 입력하지 않고 로그인을 하면 서버에서 다시 현재 폼으로 포워드 처리</p>
	<hr>

	<form name="login" method="post" action="login2.jsp">
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
</body>
</html>