<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<c:choose>

	<c:when test='${msg=="insertEbook"}'>
		<script>
			window.onload=function(){
				alert("책을 추가하였습니다.");
			}
		</script>
	</c:when>
	
	<c:when test='${msg=="modified"}'>
		<script>
			window.onload=function(){
				alert("책의 정보를 수정하였습니다.");
			}
		</script>
	</c:when>
	
	<c:when test='${msg=="deleted"}'>
		<script>
			window.onload=function(){
				alert("책을 삭제하였습니다.");
			}
		</script>
	</c:when>
	
</c:choose>

	<meta charset="UTF-8">
	<title>E-Book 목록</title>
<style>
	.cls1 {
       font-size:40px;
       text-align:center;
     }
    
     .cls2 {
       font-size:20px;
       text-align:center;
     }
</style>
</head>

<body>
	<p class='cls1'>E-Book 목록</p>
		<table border="1">
			<tr align="center" bgcolor="lightblue">
				<td width="3%"><b>시리얼</b></td>
				<td width="7%"><b>제목</b></td>
				<td width="5%"><b>작가</b></td>
				<td width="5%"><b>가격</b></td>
				<td width="3%"><b>수량</b></td>
				<td width="3%"><b>수정</b></td>
				<td width="3%"><b>삭제</b></td>
			</tr>
			
			<c:choose>
			
				<c:when test="${empty ebooksList}">
					<tr align="center">
						<td colspan="7">
							<b>등록된 책이 없습니다!</b>
						</td>
					</tr>
				</c:when>
				
				<c:when test="${!empty ebooksList}">
					<c:forEach var='ebk' items="${ebooksList}">
						<tr align="center">
							<td><b>${ebk.serial}</b></td>
							<td><b>${ebk.title}</b></td>
							<td><b>${ebk.author}</b></td>
							<td><b>${ebk.price}</b></td>
							<td><b>${ebk.qty}</b></td>
							<td><input type="button" value="수정" onclick="location.href='${contextPath}/ebook/ebookEditForm.do?serial=${ebk.serial}'" ></td>
							<td><input type="button" value="삭제" onclick="location.href='${contextPath}/ebook/delEbook.do?serial=${ebk.serial}'" ></td>
							 
						</tr>
					</c:forEach>
				</c:when>
				
			</c:choose>
		</table>
		
		<input type="button" value="E-Book 추가"  onclick="location.href='${contextPath}/ebook/ebookForm.do'"/>
		
</body>
</html>