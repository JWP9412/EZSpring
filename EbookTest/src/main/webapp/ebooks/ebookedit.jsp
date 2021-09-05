<%@page import="ebooks.EbookVO"%>
<%@page import="ebooks.EbookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>도서 정보 수정 test</title>
	</head>
<%
	
	request.setCharacterEncoding("utf-8");
	
	String serial = request.getParameter("serial");
	//int serial = Integer.parseInt(request.getParameter("serial"));
	EbookDAO ebookDAO = new EbookDAO();
	EbookVO ebook = ebookDAO.getBook(Integer.parseInt(serial));
	
%>
	
<body>
	<h1>도서 정보 수정 test</h1>
	<a href="ebooklist.jsp">메인으로 돌아가기 test</a>
	<hr>
	<form name="ebookedit" method="post" action="ebooklist.jsp">
		<table>
			<tr>
				<td>번호</td>
				<td><input type='text' name='serial' value='<%=ebook.getSerial()%>' readonly></td>
			</tr>
			
		
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="<%=ebook.getTitle() %>"></td>
			</tr>
			
			<tr>
				<td>저자</td>
				<td><input type="text" name="author" value="<%=ebook.getAuthor() %>"></td>
			</tr>
			
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" value="<%=ebook.getPrice() %>"></td>
			</tr>
			
			<tr>
				<td>수량</td>
				<td><input type="text" name="qty" value="<%=ebook.getQty() %>"></td>
			</tr>
		</table>
		<input type="submit" value=도서수정">
		<input type="reset" value="다시입력">
		<input type="hidden" name="command" value="updateBook"/>
		</table>
	</form>
	
</body>
</html>