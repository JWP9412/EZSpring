<%@page import="ebooks.EbookVO"%>
<%@page import="ebooks.EbookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상세 보기 test</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	Integer serial = Integer.parseInt(request.getParameter("serial"));
	
	EbookDAO ebookDAO = new EbookDAO();
	EbookVO ebook = ebookDAO.getBook(serial);
%>
	<h1>도서 상세보기 test</h1>
	<hr>
	<table border=1>
		<tr><td>번호</td><td><%=ebook.getSerial() %></td></tr>
		<tr><td>제목</td><td><%=ebook.getTitle() %></td></tr>
		<tr><td>저자</td><td><%=ebook.getAuthor() %></td></tr>
		<tr><td>가격</td><td><%=ebook.getPrice() %></td></tr>
		<tr><td>재고</td><td><%=ebook.getQty() %></td></tr>
	</table>
	<input type="button" onclick="location.href='ebooklist.jsp'" value="리스트로 이동">
	<input type="button" onclick="location.href='ebooklist.jsp?command=delBook&serial=<%=ebook.getSerial()%>'" value="삭제">
</body>
</html>