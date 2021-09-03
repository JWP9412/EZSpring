<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ebooks.*"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 리스트</title>
</head>
<body>
	<h1>도서 등록</h1>
	<a href="ebooklist.jsp">도서목록으로</a>
	<hr>
	<form name="ebookreg" method="post" action="ebooklist.jsp">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<td>저자</td>
				<td><input type="text" name="author"></td>
			</tr>
			
			<tr>
				<td>가격</td>
				<td><input type="text" name="price"></td>
			</tr>
			
			<tr>
				<td>수량</td>
				<td><input type="text" name="qty"></td>
			</tr>
		</table>
		<input type="submit" value="도서등록">
		<input type="reset" value="다시입력">
		<input type="hidden" name="command" value="addBook"/>
	</form>
</body>
</html>