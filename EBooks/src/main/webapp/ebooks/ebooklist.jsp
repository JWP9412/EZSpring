<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ebooks.*, java.util.List"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 관리</title>
</head>
<body>

</body>
<%

request.setCharacterEncoding("utf-8");

	EBookDAO ebookDAO = new EBookDAO();

	String command = request.getParameter("command");
	if(command != null) {
		if(command.equals("addBook")) {
			// String serial = request.getParameter("serial");
			String serial = null;
			String title  = request.getParameter("title");
			String author = request.getParameter("author");
			String price  = request.getParameter("price");
			String qty    = request.getParameter("qty");
			
			System.out.printf("[ebooklist] addBook: (%s)(%s)(%s)(%s)(%s)%n", serial, title, author, price, qty);
			EBookVO ebook = new EBookVO(serial, title, author, price, qty);
			ebookDAO.addBook(ebook);
		}
		else if(command.equals("delBook")) {
			String serial = request.getParameter("serial");
			System.out.printf("[ebooklist] delBook: serial(%s)%n", serial);
	
			if(serial != null && serial.isEmpty() != true) { 
				ebookDAO.delBook(serial);
			}
		}
		else if(command.equals("editBook")) {
			String serial = request.getParameter("serial");
			String title  = request.getParameter("title");
			String author = request.getParameter("author");
			String price  = request.getParameter("price");
			String qty    = request.getParameter("qty");
		
			System.out.printf("[ebooklist] editBook: (%s)(%s)(%s)(%s)(%s)%n", serial, title, author, price, qty);
	
			EBookVO ebook = new EBookVO(serial, title, author, price, qty);
			ebookDAO.updateBook(ebook);
		}
	}
	
	List<EBookVO> ebooks = ebookDAO.getBooks();
	
	request.setAttribute("ebooks", ebooks);
	
	RequestDispatcher dispatch = request.getRequestDispatcher("ebookview.jsp");
	dispatch.forward(request, response);
%>
</html>