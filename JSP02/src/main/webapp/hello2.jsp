<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    String jsp = "Hello, JSP";
    public String getJsp(){
    	return jsp;
    }
    %>
 <% 
 // 호출 : hello2?ver=s3.0
    String ver =  request.getParameter("ver");
   
  %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP Scripting Element</title>
</head>
<body>
	<h1>환영합니다.</h1>
	<h2><%=jsp %>: <%=ver %></h2>
	
</body>
</html>