<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ebooks.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 수정</title>
</head>
<body>

</body>
<%
request.setCharacterEncoding("utf-8");

	String serial = request.getParameter("serial");

	EBookDAO2 ebookDAO = new EBookDAO2();
	EBookVO ebook = ebookDAO.getBook(serial);
%>

	<h1>도서 수정</h1>
	<a href="ebooklist.jsp">도서목록으로</a>
	<hr>
	<form name='memberedit' method='post' action='ebooklist.jsp'>
		<table>
			<tr><td>번호</td><td><input type='text' name='serial' value='<%=ebook.getSerial()%>' readonly></td></tr>
			<tr><td>제목</td><td><input type='text' name='title' value='<%=ebook.getTitle()%>'></td></tr>
			<tr><td>저자</td><td><input type='text' name='author' value='<%=ebook.getAuthor()%>'></td></tr>
			<tr><td>가격</td><td><input type='text' name='price' value='<%=ebook.getPrice()%>'></td></tr>
			<tr><td>수량</td><td><input type='text' name='qty' value='<%=ebook.getQty()%>'></td></tr>
			<tr>
			<td><input type='submit' value='멤버수정'></td>
			<td><input type='reset' value='다시입력'></td>
			</tr>
		</table>
	<input type='hidden' name='command' value='editBook'/>
</form>


</html>