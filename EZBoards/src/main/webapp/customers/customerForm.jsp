<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />     

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>고객 등록창</title>
<body>
<form method="post"   action="${contextPath}/customer/addCustomer.do">
<h1  style="text-align:center">고객 등록창</h1>
<table  align="center">
    <tr>
       <td width="200"><p align="right">고객번호</td>
       <td width="400"><input type="text" name="num"></td>
    </tr>
    
    <tr>
        <td width="200"><p align="right">고객성함</td>
        <td width="400"><p><input type="text"  name="name"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">전화번호</td>
        <td width="400"><p><input type="tel"  name="tel"></td>
    </tr>
    <tr>
        <td width="200"><p align="right">주    소</td>
        <td width="400"><input type="text"  name="address"></td>
    </tr>
    <tr>
        <td width="200"><p>&nbsp;</p></td>
        <td width="400">
	       <input type="submit" value="등록하기">
	       <input type="reset" value="다시입력">
       </td>
    </tr>
</table>
</form>
</body>
</html>
