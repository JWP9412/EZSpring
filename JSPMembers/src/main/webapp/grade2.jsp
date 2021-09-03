<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	int score = Integer.parseInt(request.getParameter("score"));
    	String scoreResult = "F";
    	if(score >= 90){
    	 scoreResult = "A";
    	} else if(score >= 80) {
    		 scoreResult = "B";
    	} else if(score >= 70) {
    		 scoreResult = "C";
    	} else if(score >= 60) {
    		 scoreResult = "D";
    	} else{
    		 scoreResult = "F";
    	} 
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
	<h4><%=scoreResult %>등급 입니다.</h4>
	<hr>
	<a href="grade2.html">등급관리</a>
</body>
</html>