<%@page import="sun.rmi.server.Dispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="ebooks.*, java.util.List"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 test</title>
</head>
<body>

</body>
<%
	request.setCharacterEncoding("UTF-8");

	EbookDAO ebookDAO = new EbookDAO();
	
	String command = request.getParameter("command");
	System.out.println("!!! command : "+command);
	if(command != null){
		if(command.equals("addBook")){
			Integer serial = null;
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			Integer price = Integer.parseInt(request.getParameter("price"));
			Integer qty = Integer.parseInt(request.getParameter("qty"));
			
			EbookVO ebook = new EbookVO(serial, title, author, price, qty);
			System.out.printf("[ebooklist] ebookDAO.addBook(%s, %s, %s, %s, %s)",serial,title,author,price,qty);
			ebookDAO.addBook(ebook);
		}
		else if(command.equals("delBook")){
			Integer serial = Integer.parseInt(request.getParameter("serial"));
			System.out.println("[ebooklist] ebookDAO.delBook("+serial+")");
			
			if(serial != null){
			ebookDAO.delBook(serial);
			}
			else{
				System.out.println("ebookDAO.delBook("+serial+") was already Delected");
			}
			
		}
		else if(command.equals("updateBook")){
			Integer serial = Integer.parseInt(request.getParameter("serial"));
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			Integer price = Integer.parseInt(request.getParameter("price"));
			Integer qty = Integer.parseInt(request.getParameter("qty"));
			
			EbookVO ebook = new EbookVO(serial, title, author, price, qty);
			System.out.printf("[ebooklist] ebookDAO.updateBook(%s, %s, %s, %s, %s)",serial,title,author,price,qty);
			ebookDAO.updateBook(ebook);
		}
		
		
	}
	
	List<EbookVO> ebooks = ebookDAO.getBooks();
	
	request.setAttribute("ebooks", ebooks);
	
	RequestDispatcher dispatch = request.getRequestDispatcher("ebookview.jsp");
	dispatch.forward(request, response);
	
	
%>
</html>