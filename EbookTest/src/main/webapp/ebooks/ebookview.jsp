<%@page import="ebooks.*,java.util.List"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 상세 보기 test</title>
</head>
<body>
</body>
<%
	request.setCharacterEncoding("UTF-8");
	List<EbookVO> ebooks = (List<EbookVO>)request.getAttribute("ebooks");
%>

	<h1> 도서 리스트 test</h1>
	
	<table border=1>
		<tr align="center" bgcolor='#00ff00'>
			<td>번호</td>
			<td>제목</td>
			<td>저자</td>
			<td>가격</td>
			<td>수량</td>
			<td>삭제</td>
			<td>수정</td>
		</tr>
<%
	for(int cnt = 0; cnt < ebooks.size(); cnt++){
		EbookVO ebook = (EbookVO)ebooks.get(cnt);
%>
	<tr>
		<td><a href='ebookdetail.jsp?serial=<%=ebook.getSerial() %>'><%=ebook.getSerial() %></a></td>
		<td><%=ebook.getTitle() %></td>
		<td><%=ebook.getAuthor() %></td>
		<td><%=ebook.getPrice() %></td>
		<td><%=ebook.getQty() %></td>
		<td><a href='ebooklist.jsp?command=delBook&serial=<%=ebook.getSerial()%>'>삭제</a></td>
		<td><a href='ebookedit.jsp?serial=<%=ebook.getSerial()%>'>수정</a></td>
	</tr>
<% 
	}
%>
	</table>
	<a href='ebookadd.jsp'>도서 등록 test</a>


</html>