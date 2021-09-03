<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false" 
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />  
<%
request.setCharacterEncoding("UTF-8");
%>    
<html>
<head>
<c:choose>
   <c:when test='${msg=="addCustomer"}'>
      <script>
         window.onload=function(){
            alert("고객을 등록했습니다.");
         }
      </script>
   </c:when>
   <c:when test='${msg=="modified"}'>
      <script>
        window.onload=function(){
          alert("고객 정보를 수정했습니다.");
        }
      </script>
   </c:when>
   <c:when test= '${msg=="deleted"}'>
      <script>
         window.onload=function(){
            alert("고객 정보를 삭제했습니다.");
        } 
      </script>
</c:when>
</c:choose>

   <meta  charset="UTF-8">
   <title>고객 정보 출력창</title>
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
 <p class="cls1">고객정보</p>
   <table align="center" border="1" >
      <tr align="center" bgcolor="lightblue">
         <td width="10%" ><b>고객번호</b></td>
         <td width="10%" ><b>고객성함</b></td>
         <td width="10%" ><b>전화번호</b></td>
         <td width="10%"><b>주    소</b></td>
         <td width="10%" ><b>수정</b></td>
		 <td width="10%" ><b>삭제</b></td>
         
   </tr>

<c:choose>
    <c:when test="${empty  customersList}" >
      <tr align="center">
        <td colspan=6>
          <b>등록된 고객이 없습니다.</b>
       </td>  
      </tr>
   </c:when>  
   
   <c:when test="${!empty customersList}" >
      <c:forEach  var="cus" items="${customersList}" >
        <tr align="center">
          <td><a href='${contextPath}/customer/customerDetailForm.do?num=${cus.num}'> ${cus.num}</a></td>
          <td>${cus.name}</td>
          <td>${cus.tel}</td>     
          <td>${cus.address}</td>     
          <td><a href="${contextPath}/customer/customerEditForm.do?num=${cus.num}">수정</a></td>
		  <td><a href="${contextPath}/customer/delCustomer.do?num=${cus.num}">삭제</a></td>
               
       </tr>
     </c:forEach>
</c:when>
</c:choose>
   </table>  
 <p align="center">
 <input type="submit"  onclick="location.href='${contextPath}/customer/customerForm.do'" value="고객 등록하기" >
 </p>
</body>
</html>
