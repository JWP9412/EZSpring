<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 수정</title>
	<style>
  .cls1 {
     font-size:40px;
     text-align:center;
   }
</style>
</head>
<body>
<h1 class="cls1">책 정보 수정창</h1>
	<form method="post" action="${contextPath}/ebook/editEbook.do?serial=${ebookInfo.serial}">
		<table align="center">
			<tr>
			     <td width="200"><p align="right" >시리얼</td>
			     <td width="400"><input   type="number" name="serial" value="${ebookInfo.serial}" disabled ></td>
   			</tr>
   			<tr>
			     <td width="200"><p align="right" >제목</td>
			     <td width="400"><input   type="text" name="title" value="${ebookInfo.title}" ></td>
   			</tr>
   			<tr>
			     <td width="200"><p align="right" >작가</td>
			     <td width="400"><input   type="text" name="author" value="${ebookInfo.author}" ></td>
   			</tr>
   			<tr>
			     <td width="200"><p align="right" >가격</td>
			     <td width="400"><input   type="number" name="price" value="${ebookInfo.price}" ></td>
   			</tr>
   			<tr>
			     <td width="200"><p align="right" >재고</td>
			     <td width="400"><input   type="number" name="qty" value="${ebookInfo.qty}" ></td>
   			</tr>
   				<tr align="center" >
   				 	<td colspan="2" width="400">
   						 <input type="submit" value="수정하기" >
     			 		 <input type="reset" value="다시입력" > 
					</td>
  				</tr>
		</table>
	</form>
</body>
</html>