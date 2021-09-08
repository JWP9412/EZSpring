<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실</title>
<script src="http://code.jquery.com/jquery-latest.js" ></script>
<script>
	$(function(){
		$("#boards").click(function() {//아래 id와 일치
			var article = {articleNO : "2001", 
					writer : "강슬기",
					title : "IT 개발자",
					content : "개발자의 길은 무엇인가난간가?"};
			
			$.ajax({
				type : "POST",
				url : "${contextPath}/boards/add",
				contentType : "application/json",
				data : JSON.stringify(article),
				
				success:function(data, status){
					alert(data);
				},
				error: function(data,status){
					alert("처리 실패"+ status+", "+JSON.stringify(data));
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
	<h1>기사 등록 서비스</h1>
	<hr>
	<input type="button" id="boards" value="전송"/>
</body>
</html>