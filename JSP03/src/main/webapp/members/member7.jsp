<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, members.*"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="member" class="members.MemberVO" scope="page"/>
<jsp:setProperty name="member" property="*" />

<%
	MemberDBCP memberDBCP = new MemberDBCP();
	memberDBCP.addMember(member);
	
	List<MemberVO> memberList = memberDBCP.getMembers();
%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>멤버 등록 및 조회 7</title>
</head>
<body>
	<h1>멤버 등록 확인</h1>
	<table>
		<tr bgcolor="66aabb">
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>등록일자</td>
		</tr>
		<tr>
			<td><jsp:getProperty name="member" property="mid"/></td>
			<td><jsp:getProperty name="member" property="mname"/></td>
			<td><jsp:getProperty name="member" property="pwd"/></td>
			<td><jsp:getProperty name="member" property="email"/></td>
			<td><jsp:getProperty name="member" property="regdate"/></td>
		</tr>
	</table>
	
	<hr>
	<h1>멤버 목록</h1>
	<table>
		<tr bgcolor="77bbcc">
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>등록일자</td>
		<tr>
		
<%	
		for(int cnt=0; cnt < memberList.size(); cnt++) {
			MemberVO mem = (MemberVO)memberList.get(cnt);
%>		
			<tr>
				<td><%=mem.getMid()%></td>
				<td><%=mem.getMname()%></td>
				<td><%=mem.getPwd()%></td>
				<td><%=mem.getEmail()%></td>
				<td><%=mem.getRegdate()%></td>
			</tr>
<%
		}
%>		
	</table>

</body>
</html>