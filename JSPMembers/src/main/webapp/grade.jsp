<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	int score = Integer.parseInt(request.getParameter("score"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grade JSP</title>
</head>
<body>
	<h1>동급처리</h1>
	<h3>시험점수 : <%= score %></h3>
	<hr>
	<%if(score >= 90){%>
	<h4>A등급입니다.</h4>
	<%} else if(score >= 80) {%>
	<h4>B등급입니다.</h4>
	<%} else if(score >= 70) {%>
	<h4>C등급입니다.</h4>
	<%} else if(score >= 60) {%>
	<h4>D등급입니다.</h4>
	<%} else{%>
	<h4>F등급입니다.</h4>
	<%} %>
	<hr>
	<a href="grade.html">등급관리</a>
</body>
</html>