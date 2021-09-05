<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>도서 추가 test</title>
	</head>
<body>
	<h1>작성해주세요 test</h1>
	<a href="ebooklist.jsp">도서목록으로</a>
	<hr>
	<form name="ebookadd" method="post" action="ebooklist.jsp">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>	
				<td>작가</td>
				<td><input type="text" name="author"></td>
			</tr>	
			<tr>	
				<td>가격</td>
				<td><input type="number" name="price"></td>
			</tr>	
			<tr>	
				<td>수량</td>
				<td><input type="number" name="qty"></td>		
			</tr>
		</table>
		<input type="submit" value="등록">
		<input type="reset" value="재입력">
		<input type="hidden" name="command" value="addBook">
	</form>
</body>
</html>