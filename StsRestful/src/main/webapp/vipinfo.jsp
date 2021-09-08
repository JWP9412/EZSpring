<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vip Information for RESTful</title>
<script src="http://code.jquery.com/jquery-latest.js" ></script>
<script>
	$(function(){
		$("#vipinfo").click(function() {
			var vip = {id : "ezvip", 
					pwd : "1234",
					name : "이젠아카데미",
					email : "ezvip@vips.com",
					age : 10};
			
			$.ajax({
				type : "POST",
				url : "${contextPath}/vip/vipinfo.do",
				contentType : "application/json",
				data : JSON.stringify(vip),
				
				success:function(data, status){
					alert("전송 성공");
				},
				error: function(data,status){
					alert("통신 오류");
				},
				
				complete: function onCom(data, status){
					var str = JSON.stringify(data);
					alert(str);
				}
			}); //ajax
		}); //click
		
	}); //function
</script>
</head>
<body>	
	<h1>서버통신(REST)</h1>
	<hr>
	<input type="button" id="vipinfo" value="VIP 정보 전송"/>
</body>
</html>