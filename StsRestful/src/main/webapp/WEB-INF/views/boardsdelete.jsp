<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 삭제</title>
<script src="http://code.jquery.com/jquery-latest.js" ></script>
<script>
	$(function(){
		$("#boards").click(function() {//아래 id와 일치
			
			$.ajax({
				type : "delete",
				url : "${contextPath}/boards/delete/1007",
				contentType : "application/json",
				// data : JSON.stringify(article),
				
				success:function(data, status){
					alert(status);
				},
				error: function(data,status){
					alert("[처리 실패]"+ status+", "+JSON.stringify(data));
				},
				
				complete: function(data, status){
					//var str = JSON.stringify(data);
					//alert(str);
				}
			}); //ajax
		}); //click
		
	}); //function
</script>
</head>
<body>	
	<h1>기사 삭제 서비스</h1>
	<hr>
	<input type="button" id="boards" value="삭제"/>
</body>
</html>