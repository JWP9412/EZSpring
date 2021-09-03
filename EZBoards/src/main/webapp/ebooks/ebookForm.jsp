<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />     
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>E-Book 등록</title>
</head>
<body>
	<form method="post" action="${contextPath}/ebook/insertEbook.do">
		<h1 style="text-align:center">E-Book 등록</h1>
		
		<table  align="center">
		    <tr>
		       <td width="200"><p align="right">제목</td>
		       <td width="400"><input type="text" name="title"></td>
		    </tr>
		    
		    <tr>
		        <td width="200"><p align="right">작가</td>
		        <td width="400"><input type="text"  name="author"></td>
		    </tr>
		    
		    <tr>
		        <td width="200"><p align="right">가격</td>
		        <td width="400"><p><input type="number"  name="price"></td>
		    </tr>
		    
		    <tr>
		        <td width="200"><p align="right">재고</td>
		        <td width="400"><p><input type="number"  name="qty"></td>
		    </tr>
		    
		    <tr>
		        <td width="200"></td>
		        <td width="400">
			       <input type="submit" value="등록하기">
			       <input type="reset" value="다시입력">
		       </td>
		    </tr>
	</table>
		
	</form>

</body>
</html>