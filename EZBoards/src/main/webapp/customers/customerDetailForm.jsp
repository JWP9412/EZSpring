<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<head>
<meta charset="UTF-8">
<title>고객 조회창</title>
<style>
  .cls1 {
     font-size:40px;
     text-align:center;
   }
</style>
</head>
<body>
 <h1 class="cls1">고객 조회창</h1>

 <table align="center" >
   <tr>
     <td width="200"><p align="right" >고객번호</td>
     <td width="400"><input   type="text" name="num" value="${cusInfo.num}" disabled ></td>
     
   </tr>
 	
   <tr>
     <td width="200"><p align="right" >고객성함</td>
     <td width="400"><input   type="text" name="name" value="${cusInfo.name}" disabled></td>
   </tr>
   
   <tr>
     <td width="200"><p align="right" >전화번호</td>
     <td width="400"><input   type="text" name="tel" value="${cusInfo.tel}" disabled>
     </td>
   </tr>
   
   <tr>
     <td width="200"><p align="right" >주   소</td>
     <td width="400"><input   type="text" name="address"  value="${cusInfo.address}" disabled></td>
   </tr>
   
   <tr align="center" >
    <td colspan="2" width="400"><input type="submit"  onclick="location.href='${contextPath}/customer/listCustomers.do'" value="확인" >
   </tr>
 </table>

</html>
